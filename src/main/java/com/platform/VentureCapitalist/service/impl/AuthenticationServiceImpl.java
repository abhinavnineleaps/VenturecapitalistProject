package com.platform.VentureCapitalist.service;


import com.platform.VentureCapitalist.dto.UserDto;
import com.platform.VentureCapitalist.jwtAuthPacks.AuthenticationRequest;
import com.platform.VentureCapitalist.jwtAuthPacks.AuthenticationResponse;
import com.platform.VentureCapitalist.model.Token;
import com.platform.VentureCapitalist.model.TokenType;
import com.platform.VentureCapitalist.model.User;
import com.platform.VentureCapitalist.model.UserAttribute;
import com.platform.VentureCapitalist.repository.*;
import com.platform.VentureCapitalist.util.EmailUtils;
import com.platform.VentureCapitalist.util.OtpGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private EmailUtils emailUtils;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private UserAttributeRepository userAttributeRepository;

    private final VentureCapitalistDetailsRepository ventureCapitalistDetailsRepository;
    private final EntrepreneurDetailsRepository entrepreneurDetailsRepository;
    private final StartupDetailsRepository startupDetailsRepository;

    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse signUp(UserDto request) {

//        User exitunguser = userRepository.findByEmail(request.getEmail()).get();
        User exitunguser = userRepository.findByEmailAddressAndIsRegister(request.getEmail());
        if (exitunguser!=null) {
            return AuthenticationResponse.builder()
//        .token(jwtToken)
                .message("User already exit")
                .build();
        }
        User newuser = new User();
        newuser.setName(request.getName());
        newuser.setRole(request.getRole());
        newuser.setPassword(passwordEncoder.encode(request.getPassword()));
        newuser.setEmail(request.getEmail());
        newuser.setUserAttribute(null);
       //This going to be true after the completer registration
        newuser.setRegistered(false);

        User savedUser = userRepository.save(newuser);

        UserAttribute userAttribute = new UserAttribute();
        String otp = OtpGenerator.generateOTP();

        LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(5);
        userAttribute.setOtp(otp);
        userAttribute.setOtpExpiryTime(localDateTime);
        userAttribute.setOtpType("registration_otp");
        userAttribute.setUser(savedUser);
       UserAttribute savedUserAttribute= userAttributeRepository.save(userAttribute);
//       savedUser.setUserAttribute(savedUserAttribute);

        //This we have to handle

//        emailUtils.sendEmailOtp(request.getEmail(),otp);

//        var jwtToken = jwtService.generateToken(user);
//        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
//        .token(jwtToken)
                .message(" You have signup succesfully")
                .registrationKey(String.valueOf(savedUserAttribute.getReg_key()))
                .build();
    }


    // TOdo replace findbyid-> to findbyregkey and in the if statement we have to take input from from payload typeofotp and the retrun(proper message).

    public boolean validateOTP(int userId, String code) {

        Optional<UserAttribute> otpOptional = userAttributeRepository.findById(userId);

        if (otpOptional.isPresent())
        {

            UserAttribute otp = otpOptional.get();
            if (otp.getOtp().equals(code) && otp.getOtpExpiryTime().isAfter(LocalDateTime.now())) {
                // userAttributeRepo.delete(otp);
                otp.setEmail_verified(true);
                userAttributeRepository.save(otp);
                return true;
            }
        }
        return false;
    }

//public boolean validateOTP(UserAttribute user) {
//    UUID otpOptional = userAttributeRepository.findByRegistrationKey(user);
//    UserAttribute stored_regKey=new UserAttribute();
//    if(otpOptional.equals(stored_regKey.getReg_key())  && stored_regKey.getOtpExpiryTime().isAfter(LocalDateTime.now()) && stored_regKey.equals("registration_otp"))
//    {
//        stored_regKey.setEmail_verified(true);
//        userAttributeRepository.save(stored_regKey);
//        return true;
//    }
//    return false;
//    }

    public AuthenticationResponse logIn(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getUserId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

}

package com.platform.VentureCapitalist.service;


import com.platform.VentureCapitalist.jwtAuthPacks.AuthenticationRequest;
import com.platform.VentureCapitalist.jwtAuthPacks.AuthenticationResponse;
import com.platform.VentureCapitalist.model.*;
import com.platform.VentureCapitalist.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository repository;
  private final VentureCapitalistDetailsRepository ventureCapitalistDetailsRepository;
  private final EntrepreneurDetailsRepository entrepreneurDetailsRepository;
  private final StartupDetailsRepository startupDetailsRepository;

  private final TokenRepository tokenRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  @Autowired
  OtpService otpService;

  // THIS METHOD BASICALLY REGESTER THE entrepreneur IN THE DATA BASE RETURN THE TOKEN

  public AuthenticationResponse signUp(User request) {

    UserAttribute reg=new UserAttribute();
    String temp= request.getRole();
    var user = User.builder()

            .phoneNumber(request.getPhoneNumber())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
            .name(request.getName())
          .role(temp)
        .build();
    var savedUser = repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    saveUserToken(savedUser, jwtToken);
    //here we are returning the token
    return AuthenticationResponse.builder()
//        .token(jwtToken)
            .message1(" You have signup succesfully")
            .message(String.valueOf(reg.getReg_key()))
        .build();
  }

  public AuthenticationResponse logIn(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    var user = repository.findByEmail(request.getEmail())
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

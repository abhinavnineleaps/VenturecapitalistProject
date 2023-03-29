package com.platform.VentureCapitalist.service;
//import com.platform.VentureCapitalist.model.OTP;

import com.platform.VentureCapitalist.model.User;
import com.platform.VentureCapitalist.model.UserAttribute;
import com.platform.VentureCapitalist.repository.UserAttributeRepo;
import com.platform.VentureCapitalist.util.OtpGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class OtpService {
    @Autowired
    private JavaMailSender mailSender;
    public User user;
    @Autowired
    UserAttributeRepo userAttributeRepo;
//    @Autowired
//    UserService userService;
    public ResponseEntity<?> sendOTP(User user) {
        String otp = OtpGenerator.generateOTP();
        LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(5);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Your OTP");
        message.setText("OTP is " + otp);
        UserAttribute otp1 = new UserAttribute();
        //otp1.setUid(user.getUniqueId());
        otp1.setOtp(otp);
        otp1.setOtp_expiry_time(localDateTime);
        mailSender.send(message);
        userAttributeRepo.save(otp1);
//        ResponseEntity.ok(otp1.getReg_key());
        System.out.println("OTP sent successfully to your registered mail");
        otp1.setEmail_verified(false);
        UUID regKey = otp1.getReg_key();
        ResponseEntity.ok("Register Key: " + regKey);
//        userService.addUserId(otp1);
        return ResponseEntity.ok("OTP sent successfully to your registered mail");
    }

    //
//        public  boolean validation(OTP otp) {
//        String s =saveOtp;
//        if (otp.getOtp().equals(s)) {
//            //return ResponseEntity.ok("OTP validated successfully");
//            return true;
////        return "success";
//        } else
//            return false;
//            //return ResponseEntity.badRequest().body("Invalid OTP");
////      return otp.getOtp();
    public boolean validateOTP(int userId, String code) {
        Optional<UserAttribute> otpOptional = userAttributeRepo.findById(userId);
        if (otpOptional.isPresent()) {
            UserAttribute otp = otpOptional.get();
            if (otp.getOtp().equals(code) && otp.getOtp_expiry_time().isAfter(LocalDateTime.now())) {
                // userAttributeRepo.delete(otp);
                otp.setEmail_verified(true);
                userAttributeRepo.save(otp);
                return true;
            }
        }
        return false;
    }
}
//}

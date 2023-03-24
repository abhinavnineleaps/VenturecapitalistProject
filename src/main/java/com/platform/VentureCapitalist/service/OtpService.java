package com.platform.VentureCapitalist.service;

import com.platform.VentureCapitalist.model.User;
import com.platform.VentureCapitalist.util.OtpGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class OtpService {
    @Autowired
    private JavaMailSender mailSender;
    public User user;
    String saveOtp;
    public ResponseEntity<?> sendOTP(User user) {
        String otp = OtpGenerator.generateOTP();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Your OTP");
        message.setText("OTP is " + otp);
        mailSender.send(message);
        saveOtp=otp;
        return ResponseEntity.ok("OTP sent successfully");
    }
    public String savedOtp()
    {
        return saveOtp;
    }
}

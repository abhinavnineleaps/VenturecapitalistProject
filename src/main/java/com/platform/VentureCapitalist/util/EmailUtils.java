package com.platform.VentureCapitalist.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
    @Autowired
    private static JavaMailSender mailSender;
    public static void sendEmailOtp(String emailId,String otp)
    {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(emailId);
        message.setSubject("Your OTP");
        message.setText("OTP is " + otp);
//        mailSender.send(message);

    }
}

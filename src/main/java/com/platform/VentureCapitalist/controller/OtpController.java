//package com.platform.VentureCapitalist.controller;
//
//import com.platform.VentureCapitalist.model.User;
//import com.platform.VentureCapitalist.service.UserService;
//import com.platform.VentureCapitalist.util.OtpGenerator;
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.mail.javamail.JavaMailSender;
//
//import java.util.concurrent.TimeUnit;
//
//@RestController
//@RequestMapping("/api/v1/otp-controls")
//public class OtpController {
//    private UserService userService;
//    @Autowired
//    private JavaMailSender mailSender;
////    @Autowired
////    private RedisTemplate<String, Object> redisTemplate;;
////    @PostMapping("/sendOTP")
////    public ResponseEntity<String> sendOTP(@RequestParam String email){
////        String otp= OtpGenerator.generateOTP();
////        SimpleMailMessage message=new SimpleMailMessage();
////        message.setTo(email);
////        message.setSubject("Your OTP");
////        message.setText("OTP is"+otp);
////        mailSender.send(message);
//////        redisTemplate.opsForValue().set(email, otp, 5, TimeUnit.MINUTES);
////        return ResponseEntity.ok("OTP sent successfully");
////    }
//    @PostMapping("/validate")
//    public ResponseEntity<String> validateOTP(@RequestParam String email, @RequestParam String otp)
//    {
//
//        //String cachedOtp = (String) redisTemplate.opsForValue().get(email);
//        String s= OtpGenerator.generateOTP();
//        if (otp.equals(s)) {
//            return ResponseEntity.ok("OTP validated successfully");
//        } else
//            return ResponseEntity.badRequest().body("Invalid OTP");
//    }
//}

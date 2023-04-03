//package com.platform.VentureCapitalist.service;
//
//import com.platform.VentureCapitalist.model.User;
//import com.platform.VentureCapitalist.model.UserAttribute;
//import com.platform.VentureCapitalist.repository.UserAttributeRepository;
//import com.platform.VentureCapitalist.repository.UserRepository;
//import com.platform.VentureCapitalist.util.OtpGenerator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//@Service
//public class OtpService {
//    @Autowired
//    private JavaMailSender mailSender;
//    @Autowired
//    private UserAttributeRepository userAttributeRepository;
//    @Autowired
//    private UserRepository userRepository;
//    public User user;
//    String saveOtp;
//    public ResponseEntity<?> sendOTP(User user) {
//        String otp = OtpGenerator.generateOTP();
//        LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(5);
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(user.getEmail());
//        message.setSubject("Your OTP");
//        message.setText("OTP is " + otp);
//        UserAttribute otp1 = new UserAttribute();
//        //otp1.setUid(user.getUniqueId());
//        otp1.setOtp(otp);
//        otp1.setOtpExpiryTime(localDateTime);
//
//        User user123=userRepository.save(user);
//        User user12=userRepository.findById(user.getUserId()).get();
//        otp1.setUser(user123);
//        mailSender.send(message);
//        userAttributeRepository.save(otp1);
//
////        ResponseEntity.ok(otp1.getReg_key());
//        System.out.println("OTP sent successfully to your registered mail");
//        otp1.setOtpVerified(false);
////        UUID regKey = otp1.getRegistrationKey();
//        String regKey = otp1.getRegistrationKey();
//        ResponseEntity.ok("Register Key: " + regKey);
////        userService.addUserId(otp1);
//        return ResponseEntity.ok("OTP sent successfully to your registered mail");
//    }
//    public boolean validateOTP(int userId, String code) {
//        Optional<UserAttribute> otpOptional = userAttributeRepository.findById(userId);
//        if (otpOptional.isPresent()) {
//            UserAttribute otp = otpOptional.get();
//            if (otp.getOtp().equals(code) && otp.getOtpExpiryTime().isAfter(LocalDateTime.now())) {
//                // userAttributeRepo.delete(otp);
//                otp.setOtpVerified(true);
//                userAttributeRepository.save(otp);
//                return true;
//            }
//        }
//        return false;
//    }
//}

package com.platform.VentureCapitalist.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.platform.VentureCapitalist.model.OTP;
import com.platform.VentureCapitalist.model.User;
import com.platform.VentureCapitalist.service.OtpService;
import com.platform.VentureCapitalist.service.UserService;
import com.platform.VentureCapitalist.util.OtpGenerator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user-controller")
public class UserController {

  @Autowired
  private UserService userService;
  @Autowired
  private OtpService otpService;
  @GetMapping
  public ResponseEntity<?> securedFunctionPoint() {
    return ResponseEntity.ok("Your token is authenticated");
  }

  @RequestMapping(value = "/signup",method = RequestMethod.POST)
  public User createUser(@RequestBody User user)
  {
    otpService.sendOTP(user);
    return userService.saveUser(user);
  }
  @RequestMapping(value = "/validate",method = RequestMethod.GET)
  public ResponseEntity<String> validateOTP(@RequestBody OTP otp)
  {
    //String cachedOtp = (String) redisTemplate.opsForValue().get(email);
//    otp.stripIndent()
    String s=otpService.savedOtp();
    if (otp.getOtp().equals(s)) {
      return ResponseEntity.ok("OTP validated successfully");
//        return "success";
    } else
      return ResponseEntity.badRequest().body("Invalid OTP");
//      return otp.getOtp();
  }
}

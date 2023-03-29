package com.platform.VentureCapitalist.controller;

import com.platform.VentureCapitalist.exceptions.MismatchTypeorBlankException;
import com.platform.VentureCapitalist.jwtAuthPacks.AuthenticationRequest;
import com.platform.VentureCapitalist.jwtAuthPacks.AuthenticationResponse;
//import com.platform.VentureCapitalist.model.OTP;
import com.platform.VentureCapitalist.model.UserAttribute;
import com.platform.VentureCapitalist.repository.UserAttributeRepo;
import com.platform.VentureCapitalist.service.AuthenticationService;
import com.platform.VentureCapitalist.model.User;
import com.platform.VentureCapitalist.service.OtpService;
import com.platform.VentureCapitalist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;
  @Autowired
  private UserService userService;
  UserAttribute userAttribute;
  @Autowired
  OtpService otpService;
  @Autowired
  UserAttributeRepo userAttributeRepo;

  //HERE WE ARE REGISTERING AS A ENTREPRENEUR

//  @PostMapping("/registration/Entrepreneur")
//  public ResponseEntity<AuthenticationResponse> registerEmp(@RequestBody User user)throws MismatchTypeorBlankException {
////    if(result.hasErrors())
////      throw new MismatchTypeorBlankException("type mismatch exception or may be blank field");
//    otpService.sendOTP(user);
//    return ResponseEntity.ok(service.registerAsEntrepreneur(user));
    @PostMapping("/registration/Entrepreneur")
    public ResponseEntity<?> registerEmp(@RequestBody User user)throws MismatchTypeorBlankException {
//    if(result.hasErrors())
//      throw new MismatchTypeorBlankException("type mismatch exception or may be blank field");
      service.registerAsEntrepreneur(user);
      return ResponseEntity.ok(otpService.sendOTP(user));
  }
  @PostMapping("/authentication")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }
//  @RequestMapping(value = "/validate",method = RequestMethod.GET)
//  public ResponseEntity<String> validOTP(@RequestBody UserAttribute otp)
//  {
//    if (otpService.validation(otp))
//      return ResponseEntity.ok("OTP validated successfully");
//    else
//      return ResponseEntity.badRequest().body("Invalid OTP");
//  }
    @RequestMapping(value = "/validate",method = RequestMethod.GET)
  public ResponseEntity<String> validation(@RequestBody UserAttribute otp)
  {
    if (otpService.validateOTP(otp.getId(),otp.getOtp())) {
      return ResponseEntity.ok("OTP validated successfully");
    }
    else
      return ResponseEntity.badRequest().body("Invalid OTP");

  }



}

package com.platform.VentureCapitalist.controller;

import com.platform.VentureCapitalist.exceptions.MismatchTypeorBlankException;
import com.platform.VentureCapitalist.jwtAuthPacks.AuthenticationRequest;
import com.platform.VentureCapitalist.jwtAuthPacks.AuthenticationResponse;
import com.platform.VentureCapitalist.model.OTP;
import com.platform.VentureCapitalist.service.AuthenticationService;
import com.platform.VentureCapitalist.model.User;
import com.platform.VentureCapitalist.service.OtpService;
import com.platform.VentureCapitalist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;
  @Autowired
  private UserService userService;
  @Autowired
  OtpService otpService;

  //HERE WE ARE REGISTERING AS A ENTREPRENEUR

  @PostMapping("/registration/Entrepreneur")
  public ResponseEntity<AuthenticationResponse> registerEmp(@RequestBody User user)throws MismatchTypeorBlankException {
//    if(result.hasErrors())
//      throw new MismatchTypeorBlankException("type mismatch exception or may be blank field");
    otpService.sendOTP(user);
    return ResponseEntity.ok(service.registerAsEntrepreneur(user));
  }
////  @PostMapping("/reg-demo")
////  public User createEmp(@RequestBody SignUp signUp) {
////    User user=new User();
////    user.setName((signUp.getName()));
////    user.setEmail(signUp.getEmail());
////    user.setPassword(signUp.getPass());
////    return userService.saveUser(user);
//  }

  @PostMapping("/authentication")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }
  @RequestMapping(value = "/validate",method = RequestMethod.GET)
  public ResponseEntity<String> validOTP(@RequestBody OTP otp)
  {
    return otpService.validation(otp);
  }


}

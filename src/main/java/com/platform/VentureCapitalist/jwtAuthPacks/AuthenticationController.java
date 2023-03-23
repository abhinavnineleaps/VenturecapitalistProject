package com.platform.VentureCapitalist.jwtAuthPacks;

import com.platform.VentureCapitalist.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
  @RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  //HERE WE ARE REGISTERING AS A ENTREPRENEUR

  @PostMapping("/registration/Entrepreneur")
  public ResponseEntity<AuthenticationResponse> registerEnp(
      @RequestBody User request
  ) {
    return ResponseEntity.ok(service.registerAsEntrepreneur(request));
  }


  @PostMapping("/authentication")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }


}

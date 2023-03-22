package com.platform.VentureCapitalist.jwtAuthPacks;

import com.platform.VentureCapitalist.model.UserProfile;
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
      @RequestBody UserProfile request
  ) {
    return ResponseEntity.ok(service.registerAsEntrepreneur(request));
  }

  //HERE WE ARE REGISTERING AS A VC

  @PostMapping("/registration/VC")
  public ResponseEntity<AuthenticationResponse> registerVc(
          @RequestBody UserProfile request
  ) {
    return ResponseEntity.ok(service.registerVC(request));
  }





  @PostMapping("/authentication")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }


}

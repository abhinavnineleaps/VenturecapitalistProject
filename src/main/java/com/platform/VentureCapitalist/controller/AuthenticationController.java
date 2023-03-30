package com.platform.VentureCapitalist.controller;

import com.platform.VentureCapitalist.jwtAuthPacks.AuthenticationRequest;
import com.platform.VentureCapitalist.jwtAuthPacks.AuthenticationResponse;
import com.platform.VentureCapitalist.model.EntrepreneurDetails;
import com.platform.VentureCapitalist.model.User;
import com.platform.VentureCapitalist.model.UserAttribute;
import com.platform.VentureCapitalist.model.VentureCapitalistDetails;
import com.platform.VentureCapitalist.repository.EntrepreneurDetailsRepository;
import com.platform.VentureCapitalist.repository.StartupDetailsRepository;
import com.platform.VentureCapitalist.service.AuthenticationService;
import com.platform.VentureCapitalist.service.EntrepreneurService;
import com.platform.VentureCapitalist.service.OtpService;
import com.platform.VentureCapitalist.service.VentureService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api.venturecapitalist.com")
@RequiredArgsConstructor
public class AuthenticationController {

    // For searching

    //    private SearchServiceInterface searchServiceInterfface;
    @Autowired
    private final AuthenticationService service;
    @Autowired
    private OtpService otpService;
    @Autowired
    private EntrepreneurService entrepreneurService;
    @Autowired
    private VentureService ventureService;
    @Autowired
    private StartupDetailsRepository startupDetailsRepository;
    @Autowired
    private EntrepreneurDetailsRepository entrepreneurDetailsRepository;
    UserAttribute userAttribute;
    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser(@RequestBody User user) {
        //"" UNDER WROKING"" //
        otpService.sendOTP(user);
        return ResponseEntity.ok(service.signUp(user));

    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> logInUser(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.logIn(request));
    }

    // "" UNDER WORKING "" //

    @PostMapping("/validate")
    public ResponseEntity<String> validation(@RequestBody UserAttribute otp)
    {
        if (otpService.validateOTP(otp.getUserAttributeId(),otp.getOtp())) {
            return ResponseEntity.ok("OTP validated successfully");
        }
        else
            return ResponseEntity.badRequest().body("Invalid OTP");
    }

    @PostMapping("/registration-vc")
    public ResponseEntity<VentureCapitalistDetails> registerVC(@RequestBody VentureCapitalistDetails ventureCapitalistDetails) {
        {
            return ResponseEntity.ok(ventureService.saveVenture(ventureCapitalistDetails));
        }
    }

    @PostMapping("/registration-ent")
    public ResponseEntity<EntrepreneurDetails> registerEntrepreneur(@RequestBody EntrepreneurDetails entrepreneurDetails) {
        {


            return ResponseEntity.ok(entrepreneurService.saveEntrepreneur(entrepreneurDetails));
        }
    }

// UNDER WORKKING//


//  @GetMapping("/search")
//  public ResponseEntity<List<User>> searchProducts(@RequestParam("query") String query){
//    return ResponseEntity.ok(searchServiceInterfface.searchUser(query));
//  }


}







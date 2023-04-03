package com.platform.VentureCapitalist.controller;

import com.platform.VentureCapitalist.dto.*;
import com.platform.VentureCapitalist.jwtAuthPacks.AuthenticationRequest;
import com.platform.VentureCapitalist.jwtAuthPacks.AuthenticationResponse;
import com.platform.VentureCapitalist.repository.EntrepreneurDetailsRepository;
import com.platform.VentureCapitalist.repository.StartupDetailsRepository;
import com.platform.VentureCapitalist.repository.UserAttributeRepository;
import com.platform.VentureCapitalist.service.AuthenticationService;
import com.platform.VentureCapitalist.service.EntrepreneurDetailsService;
import com.platform.VentureCapitalist.service.VentureDetailsService;
import com.platform.VentureCapitalist.service.impl.VentureDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api.venturecapitalist.com")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private final AuthenticationService authenticationService;
    @Autowired
    private final VentureDetailsService ventureDetailsService;

    @Autowired
    private final EntrepreneurDetailsService entrepreneurDetailsService;
    @Autowired
    private VentureDetailsServiceImpl ventureDetailsServiceImpl;
    @Autowired
    private StartupDetailsRepository startupDetailsRepository;
    @Autowired
    private EntrepreneurDetailsRepository entrepreneurDetailsRepository;

    @Autowired
    private UserAttributeRepository userAttributeRepository;










    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(authenticationService.signUp(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> logInUser(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.logIn(request));
    }

    // "" UNDER WORKING "" //

    @PostMapping("/validate")
    public ResponseEntity<ResponseDto> validation(@RequestBody UserAttributeDto userAttributeDto) throws Exception {



            return authenticationService.validateOTP(userAttributeDto);
    }

    @PostMapping("/registration-vc")
    public ResponseDto registerVC(@RequestBody VentureCaptitalDetailsDto ventureCaptitalDetailsDto) {

        {
            return ventureDetailsService.saveVenture(ventureCaptitalDetailsDto);
//            return ResponseEntity.ok(ventureDetailsService.saveVenture(ventureCaptitalDetailsDto));
        }
    }

    @PostMapping("/registration-ent")
    public ResponseDto registerEntrepreneur(@RequestBody EntrepreneurDetailsDto entrepreneurDetailsDto) {
        {


            return entrepreneurDetailsService.saveEntrepreneur(entrepreneurDetailsDto);

        }
    }

// UNDER WORKKING//


//  @GetMapping("/search")
//  public ResponseEntity<List<User>> searchProducts(@RequestParam("query") String query){
//    return ResponseEntity.ok(searchServiceInterfface.searchUser(query));
//  }


}







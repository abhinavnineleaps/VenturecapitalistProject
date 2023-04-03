package com.platform.VentureCapitalist.service;

import com.platform.VentureCapitalist.dto.ResponseDto;
import com.platform.VentureCapitalist.dto.UserAttributeDto;
import com.platform.VentureCapitalist.dto.UserDto;
import com.platform.VentureCapitalist.jwtAuthPacks.AuthenticationRequest;
import com.platform.VentureCapitalist.jwtAuthPacks.AuthenticationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
     AuthenticationResponse signUp(UserDto request);
    ResponseEntity<ResponseDto> validateOTP(UserAttributeDto user) throws Exception;
     AuthenticationResponse logIn(AuthenticationRequest request);
}

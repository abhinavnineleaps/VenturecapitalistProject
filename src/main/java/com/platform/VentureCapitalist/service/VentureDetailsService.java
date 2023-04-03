package com.platform.VentureCapitalist.service;

import com.platform.VentureCapitalist.dto.ResponseDto;
import com.platform.VentureCapitalist.dto.VentureCaptitalDetailsDto;
import org.springframework.stereotype.Service;

@Service
public interface VentureDetailsService {
    ResponseDto saveVenture(VentureCaptitalDetailsDto ventureCaptitalDetailsDto);
}

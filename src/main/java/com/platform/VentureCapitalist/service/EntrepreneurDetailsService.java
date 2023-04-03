package com.platform.VentureCapitalist.service;

import com.platform.VentureCapitalist.dto.EntrepreneurDetailsDto;
import com.platform.VentureCapitalist.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface EntrepreneurDetailsService {
    ResponseDto saveEntrepreneur(EntrepreneurDetailsDto entrepreneurDetailsDto);
}

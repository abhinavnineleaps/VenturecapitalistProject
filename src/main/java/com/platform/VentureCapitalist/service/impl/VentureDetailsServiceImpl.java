package com.platform.VentureCapitalist.service;

import com.platform.VentureCapitalist.dto.VentureCaptitalDetailsDto;
import com.platform.VentureCapitalist.model.VentureCapitalistDetails;
import com.platform.VentureCapitalist.repository.VentureCapitalistDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentureDetailsService {
    @Autowired
    private VentureCapitalistDetailsRepository ventureCapitalistDetailsRepository;

    public VentureDetailsService(VentureCapitalistDetailsRepository ventureCapitalistDetailsRepository) {
        this.ventureCapitalistDetailsRepository = ventureCapitalistDetailsRepository;
    }
    public VentureCaptitalDetailsDto saveVenture(VentureCaptitalDetailsDto ventureCaptitalDetailsDto)
    {
        return ventureCapitalistDetailsRepository.save(ventureCaptitalDetailsDto);
        
    }
}

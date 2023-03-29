package com.platform.VentureCapitalist.service;

import com.platform.VentureCapitalist.model.VentureCapitalistDetails;
import com.platform.VentureCapitalist.repository.VentureCapitalistDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentureService {
    @Autowired
    private VentureCapitalistDetailsRepository ventureCapitalistDetailsRepository;

    public VentureService(VentureCapitalistDetailsRepository ventureCapitalistDetailsRepository) {
        this.ventureCapitalistDetailsRepository = ventureCapitalistDetailsRepository;
    }
    public VentureCapitalistDetails saveVenture(VentureCapitalistDetails ventureCapitalistDetails)
    {
        return ventureCapitalistDetailsRepository.save(ventureCapitalistDetails);
    }
}

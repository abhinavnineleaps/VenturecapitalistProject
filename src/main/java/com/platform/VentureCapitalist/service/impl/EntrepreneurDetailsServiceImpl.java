package com.platform.VentureCapitalist.service.impl;

import com.platform.VentureCapitalist.model.EntrepreneurDetails;
import com.platform.VentureCapitalist.repository.EntrepreneurDetailsRepository;
import com.platform.VentureCapitalist.repository.StartupDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrepreneurDetailsService {

    @Autowired
  private  EntrepreneurDetailsRepository entrepreneurDetailsRepository;
    @Autowired
    private StartupDetailsRepository startupDetailsRepository;
    public EntrepreneurDetailsService(EntrepreneurDetailsRepository entrepreneurDetailsRepository) {
        this.entrepreneurDetailsRepository = entrepreneurDetailsRepository;
    }
    public EntrepreneurDetails saveEntrepreneur(EntrepreneurDetails entrepreneurDetails)
    {
        return entrepreneurDetailsRepository.save(entrepreneurDetails);
    }
//    public EntrepreneurDetails addEnt(EntrepreneurDetails entrepreneurDetails) {
//        StartupDetails starupDtetails=startupDetailsRepository.findById(entrepreneurDetails.getStartupDetails().getStartUpId()).get();
//        entrepreneurDetails.setStartupDetails(startupDetails);
//        return entrepreneurDetailsRepository.save(entrepreneurDetails);
//    }

}


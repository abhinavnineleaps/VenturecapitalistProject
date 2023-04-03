package com.platform.VentureCapitalist.service.impl;

import com.platform.VentureCapitalist.dto.EntrepreneurDetailsDto;
import com.platform.VentureCapitalist.dto.ResponseDto;
import com.platform.VentureCapitalist.model.EntrepreneurDetails;
import com.platform.VentureCapitalist.model.StartupDetails;
import com.platform.VentureCapitalist.model.UserAttribute;
import com.platform.VentureCapitalist.repository.EntrepreneurDetailsRepository;
import com.platform.VentureCapitalist.repository.StartupDetailsRepository;
import com.platform.VentureCapitalist.repository.UserAttributeRepository;
import com.platform.VentureCapitalist.repository.UserRepository;
import com.platform.VentureCapitalist.service.EntrepreneurDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrepreneurDetailsServiceImpl implements EntrepreneurDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAttributeRepository userAttributeRepository;
    @Autowired
  private  EntrepreneurDetailsRepository entrepreneurDetailsRepository;
    @Autowired
    private StartupDetailsRepository startupDetailsRepository;
    public EntrepreneurDetailsServiceImpl(EntrepreneurDetailsRepository entrepreneurDetailsRepository) {
        this.entrepreneurDetailsRepository = entrepreneurDetailsRepository;
    }
    public ResponseDto saveEntrepreneur(EntrepreneurDetailsDto entrepreneurDetailsDto)
    {
        EntrepreneurDetails entrepreneurDetails=new EntrepreneurDetails();
        entrepreneurDetails.setName(entrepreneurDetailsDto.getName());
        entrepreneurDetails.setProfileImage(entrepreneurDetailsDto.getProfileImage());
        entrepreneurDetails.setCountry(entrepreneurDetailsDto.getCountry());
        entrepreneurDetails.setState(entrepreneurDetailsDto.getState());
        entrepreneurDetails.setPin(entrepreneurDetailsDto.getPin());
        entrepreneurDetailsRepository.save(entrepreneurDetails);

        StartupDetails startupDetails=new StartupDetails();
        startupDetails.setStartUpName(entrepreneurDetailsDto.getStartUpName());
        startupDetails.setStartupSummary(entrepreneurDetailsDto.getStartupSummary());
        startupDetails.setDomain(entrepreneurDetailsDto.getDomain());
        startupDetailsRepository.save(startupDetails);


        UserAttribute userAttribute = userAttributeRepository.findByRegistrationKey(entrepreneurDetailsDto.getRegistrationKeyEntrepreneur());
        int ui = userAttribute.getUser().getUserId();
        userRepository.updateRegistrationStatus(ui);
        return ResponseDto.builder()
//        .token(jwtToken)
                .message(" You have Register succesfully as Entrepreneur")
                .build();

    }


//    public EntrepreneurDetails addEnt(EntrepreneurDetails entrepreneurDetails) {
//        StartupDetails starupDtetails=startupDetailsRepository.findById(entrepreneurDetails.getStartupDetails().getStartUpId()).get();
//        entrepreneurDetails.setStartupDetails(startupDetails);
//        return entrepreneurDetailsRepository.save(entrepreneurDetails);
//    }

}


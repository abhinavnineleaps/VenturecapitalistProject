package com.platform.VentureCapitalist.service.impl;

import com.platform.VentureCapitalist.dto.ResponseDto;
import com.platform.VentureCapitalist.dto.VentureCaptitalDetailsDto;
import com.platform.VentureCapitalist.model.UserAttribute;
import com.platform.VentureCapitalist.model.VentureCapitalistDetails;
import com.platform.VentureCapitalist.repository.UserAttributeRepository;
import com.platform.VentureCapitalist.repository.UserRepository;
import com.platform.VentureCapitalist.repository.VentureCapitalistDetailsRepository;
import com.platform.VentureCapitalist.service.VentureDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentureDetailsServiceImpl implements VentureDetailsService {
    @Autowired
    private UserAttributeRepository userAttributeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VentureCapitalistDetailsRepository ventureCapitalistDetailsRepository;

    public VentureDetailsServiceImpl(VentureCapitalistDetailsRepository ventureCapitalistDetailsRepository) {
        this.ventureCapitalistDetailsRepository = ventureCapitalistDetailsRepository;
    }
    public ResponseDto saveVenture(VentureCaptitalDetailsDto ventureCaptitalDetailsDto)
    {
        VentureCapitalistDetails ventureCapitalistDetails=new VentureCapitalistDetails();
        ventureCapitalistDetails.setBio(ventureCaptitalDetailsDto.getBio());
        ventureCapitalistDetails.setCity(ventureCaptitalDetailsDto.getCity());
        ventureCapitalistDetails.setPin(ventureCaptitalDetailsDto.getPin());
        ventureCapitalistDetails.setCountry(ventureCaptitalDetailsDto.getCountry());
        ventureCapitalistDetails.setExpertise(ventureCaptitalDetailsDto.getExpertise());
        ventureCapitalistDetails.setVcLinkedin(ventureCaptitalDetailsDto.getVcLinkedin());
        ventureCapitalistDetails.setSummary(ventureCapitalistDetails.getSummary());
        ventureCapitalistDetails.setWebsite(ventureCapitalistDetails.getWebsite());
        ventureCapitalistDetailsRepository.save(ventureCapitalistDetails);



        UserAttribute userAttribute = userAttributeRepository.findByRegistrationKey(ventureCaptitalDetailsDto.getRegistrationKeyVc());
        int uid = userAttribute.getUser().getUserId();
        userRepository.updateRegistrationStatus(uid);



        return ResponseDto.builder()
//              .token(jwtToken)
                .message(" You have Register succesfully as Venture captilist")
                .build();

    }
}

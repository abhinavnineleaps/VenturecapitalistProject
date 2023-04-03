package com.platform.VentureCapitalist.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentureCaptitalDetailsDto {
    private String bio;
    private String expertise;
    private String vcLinkedin;
    private String country;
    private String state;
    private String city;
    private long pin;
    private long buildingNo;
    private long Contact;
    private String profileImage;
    private UUID registrationKeyVc;
}

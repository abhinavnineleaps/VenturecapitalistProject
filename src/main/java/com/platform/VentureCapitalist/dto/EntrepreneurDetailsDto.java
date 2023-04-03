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
public class EntrepreneurDetailsDto {
    private String location;
    private String name;
    private String Country;
    private String state;
    private String pin;
    private String profileImage;

    private String startUpName;
    private String linkedin;
    private String startupSummary;
    private String websiteUrl;
    private String domain;
    private String coEmail;
    private String coRole;
    private String coName;
    private UUID registrationKeyEntrepreneur;
}

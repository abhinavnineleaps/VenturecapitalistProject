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
public class UserAttributeDto {
    private String otp;

    private String otpType;
    private UUID registerKey;
//private String registerKey;
}

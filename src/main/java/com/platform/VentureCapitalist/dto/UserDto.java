package com.platform.VentureCapitalist.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;

    private String email;

    private String password;

    private String phoneNumber;
    private String role;
    private boolean registered;
}

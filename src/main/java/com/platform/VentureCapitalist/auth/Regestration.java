package com.platform.VentureCapitalist.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Regestration {

  private String firstname;
  private String lastname;
  private String email;
  private String password;
}

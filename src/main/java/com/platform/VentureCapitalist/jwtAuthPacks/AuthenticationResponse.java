package com.platform.VentureCapitalist.jwtAuthPacks;

import com.platform.VentureCapitalist.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

  private String token;
  private String registrationKey;
  private String message;
  private User user;
}

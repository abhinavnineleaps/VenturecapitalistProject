package com.platform.VentureCapitalist.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Token")
public class Token {

  @Id
  @GeneratedValue
  @Column(name ="token_id")
  public Integer tokenId;

  @Column(unique = true)
  public String token;

  @Enumerated(EnumType.STRING)
  public TokenType tokenType = TokenType.BEARER;

  public boolean revoked;

  public boolean expired;


  @ManyToOne
  @JoinColumn(name = "user_id")
  public User user;
}

package com.platform.VentureCapitalist.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userProfile")
// LOGIN PART
//HRE THE USER DETAILS CLASS IS FROM THE SPRING SECURITY CLASS WHICH BASICALLY HELPS SPRING TO MAKE IT EASY TO AUTHORIZE

public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "unique_id")
  private int uniqueId;
  @Column(name = "name")
  private String name;
  @Column(name = "email")
  private String email;
  @Column(name = "password")
  private String password;
  @Column(name = "phone_number")
  private String phoneNumber;

//  @Column(name = "venture_id")
//  private String VcId;
//
//  @Column(name = "entrepreneur_id")
//  private String entrepreneurId;
//  @Column(name = "user_attribute_id")
//  private String userAttributeId;

  @Column(name = "roles")
  private String roles;

//  private VentureCapitalistDetails vcId;
//   private EntrepreneurDetails eId;

  @OneToOne(targetEntity = VentureCapitalistDetails.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "ven_details", referencedColumnName = "ven_id")
  private VentureCapitalistDetails ventureCapitalistDetails;

  @OneToOne(targetEntity = EntrepreneurDetails.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "ent_details", referencedColumnName = "ent_id")
  private EntrepreneurDetails entrepreneurDetails;

  @OneToOne(targetEntity = UserAttribute.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "usr_attr", referencedColumnName = "userAttribute_id")
  private UserAttribute userAttribute;
  @Enumerated(EnumType.STRING)
  private Role role;
  @OneToMany(mappedBy = "user")
  private List<Token> tokens;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  // THIS METHOD BASICALLY RETURN THE ROLE
//  @Override
//  public Collection<? extends GrantedAuthority> getAuthorities() {
//    return List.of(new SimpleGrantedAuthority(role.name()));
//  }
  @Override
  public String getPassword() {
    return password;
  }
  @Override
  public String getUsername() {
    return email;
  }
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }
  @Override
  public boolean isEnabled() {
    return true;
  }

}

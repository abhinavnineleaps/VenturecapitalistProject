package com.platform.VentureCapitalist.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Builder
@Entity
@Table(name = "userProfile")
// LOGIN PART
//HRE THE USER DETAILS CLASS IS FROM THE SPRING SECURITY CLASS WHICH BASICALLY HELPS SPRING TO MAKE IT EASY TO AUTHORIZE
public class User implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")//pk
  private int userId;
  @Column(name = "name")
  private String name;
  @Column(name = "email")
  private String email;
  @Column(name = "password")
  private String password;
  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "confirm_password")
  private String VcId;

  @Column(name = "entrepreneur_id")
  private String entrepreneurId;
  @Column(name = "user_attribute_id")
  private String userAttributeId;

  private boolean registered;

  public boolean isRegistered() {
    return registered;
  }

  public void setRegistered(boolean registered) {
    this.registered = registered;
  }

  @Column(name = "roles")
  private String role;

//  @OneToOne(targetEntity = VentureCapitalistDetails.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//  @JoinColumn(name = "ven_details", referencedColumnName = "vc_id")
//  private VentureCapitalistDetails ventureCapitalistDetails;
//
//  @OneToOne(targetEntity = EntrepreneurDetails.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//  @JoinColumn(name = "ent_details", referencedColumnName = "ent_id")
//  private EntrepreneurDetails entrepreneurDetails;

  @OneToOne(targetEntity = UserAttribute.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
  @JoinColumn(name = "usr_attr", referencedColumnName = "userAttribute_id")
  private UserAttribute userAttribute;


// given below are the method of user implementation class.
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }
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

package com.platform.VentureCapitalist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userProfile")
public class UserProfile {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "unique_id")
  private int id;
  @Column(name = "name")
  private String name;
  @Column(name = "email")
  private String email;
  @Column(name = "password")
  private String password;
  @Column(name = "confirm_password")
  private String confirm_password;

  //private VentureCapitalistDetails vcId;
  // private EntrepreneurDetails eId;
  @OneToOne(targetEntity = EntrepreneurDetails.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "ent_details", referencedColumnName = "ent_id")
  private EntrepreneurDetails entrepreneurDetails;
  @OneToOne(targetEntity = VentureCapitalistDetails.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "ven_details", referencedColumnName = "ven_id")
  private VentureCapitalistDetails ventureCapitalistDetails;
  @OneToOne(targetEntity = UserAttribute.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "usr_attr", referencedColumnName = "userAttribute_id")
  private UserAttribute userAttribute;
}
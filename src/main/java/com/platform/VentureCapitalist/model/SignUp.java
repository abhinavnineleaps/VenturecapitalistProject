package com.platform.VentureCapitalist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "signUp")
public class SignUp {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name ="unique_id")
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
//  private EntrepreneurDetails eId;
//  @OneToOne(targetEntity = EntrepreneurDetails.class,cascade = CascadeType.ALL,mappedBy = "entrepreneurDetails")
//  @JoinColumn(name = "ent_details", referencedColumnName = "id")
//  private List<EntrepreneurDetails>entrepreneurDetails=new ArrayList<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

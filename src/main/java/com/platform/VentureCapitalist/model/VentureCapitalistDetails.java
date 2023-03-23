package com.platform.VentureCapitalist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
//import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ventureDetails")
public class VentureCapitalistDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="ven_id")
    private int id;
//    @Column(name = "name")
//    private String vName= signUp.getName();
    @Column(name = "location")
    private String location;
    @OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private User user;

}


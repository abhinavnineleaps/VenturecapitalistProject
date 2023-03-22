package com.platform.VentureCapitalist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entrepreneurDetails")
public class EntrepreneurDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="ent_id")
    private int id;
//    @Column(name = "name")
//    public String sName=signUp.getName();
    @Column(name = "bio")
    private String bio;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private UserProfile userProfile;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "startup_details",referencedColumnName = "startupId")
    private StartupDetails startupDetails;


}

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "name")
//    public String sName=signUp.getName();
    @Column(name ="ent_id")
    private int id;
    @Column(name = "bio")
    private String bio;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private User user;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "startup_details",referencedColumnName = "startupId")
    private StartupDetails startupDetails;




}

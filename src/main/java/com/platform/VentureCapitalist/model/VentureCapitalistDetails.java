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
@Table(name = "ventureDetails")
public class  VentureCapitalistDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="vc_id") //Primary key for this table
    private int vcId;
    @Column(name = "bio")
    private String bio;
    @Column(name="expertise")
    private String expertise;
//    @Column(name = "location")
//    private String location;
    @Column(name = "vc-Linkedin")
    private String vcLinkedin;
    @Column(name = "country")
    private String country;
    @Column(name = "state")
    private String state;
    @Column(name = "city")
    private long city;
    @Column(name = "pin")
    private long pin;
    @Column(name = "building_no")
    private long buildingNo;
    @Column(name = "contact")
    private long Contact;
    @Column(name = "profile_image")
    private String profileImage;
//    @OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
@OneToOne(mappedBy = "ventureCapitalistDetails",cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private User user;

}


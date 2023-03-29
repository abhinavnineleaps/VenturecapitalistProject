package com.platform.VentureCapitalist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entrepreneurDetails")
public class EntrepreneurDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ent_id")// PK
    private int entId;
    @Column(name = "location")
    private String location;
    @Column(name = "name")
    private String name;
    @Column(name = "country")
    private String Country;
    @Column(name = "state")
    private String state;
    @Column(name = "pin")
    private String pin;
    @Column(name = "profile_image")
    private String profileImage;


//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @OneToOne(mappedBy = "entrepreneurDetails",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private User user;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "startup_details",referencedColumnName = "startupId")
    private StartupDetails startupDetails;




}

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
@Entity(name = "startupDetails")
@Table(name = "startupDetails")
public class StartupDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "startupId")//pk
    private int startUpId;
    @Column(name = "startupName")
    private String startUpName;

    private String linkedin;
    private String startupSummary;
    private String websiteUrl;
    private String domain;
private String coEmail;
private String coRole;
private String coName;

    // other membervala part kana ha abi

//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//@OneToOne(mappedBy = "startupDetails",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private EntrepreneurDetails entrepreneurDetails;


}
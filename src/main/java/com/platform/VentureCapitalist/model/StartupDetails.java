package com.platform.VentureCapitalist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "startupDetails")
@Table(name = "startupDetails")
public class StartupDetails {
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private EntrepreneurDetails entrepreneurDetails;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "startupId")
    private int startUpId;
    @Column(name = "startupName")
    private String startUpName;

}
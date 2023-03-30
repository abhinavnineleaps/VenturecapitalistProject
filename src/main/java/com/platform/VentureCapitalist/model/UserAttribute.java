package com.platform.VentureCapitalist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userAttributes")
public class UserAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userAttribute_id")// PK
    private int userAttributeId;
    @OneToOne(mappedBy = "userAttribute",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User user;
    @Column(name = "Otp")
    private String otp;

    @Column(name = "otp_type")
    private String otpType;
    @Column(name = "otp_expiry_time")
    private LocalDateTime otpExpiryTime;
    @Column(name = "reg_key")
    private UUID reg_key= UUID.randomUUID();
    @Column(name = "email_verified")
    private boolean email_verified;
//    @OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
}







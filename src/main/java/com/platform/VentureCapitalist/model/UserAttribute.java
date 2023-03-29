package com.platform.VentureCapitalist.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(name = "Otp")
    private String otp;

    @Column(name = "otp_type")
    private String otpType;
    @Column(name = "otp_expiry_date")
    private String otpExpiryDate;
    @Column(name = "registration_key")
    private String registrationKey;
//    @OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    @OneToOne(mappedBy = "userAttribute",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User user;
}







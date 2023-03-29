package com.platform.VentureCapitalist.model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "userAttributes")
public class UserAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userAttribute_id")
    private int id;
    @Column(name = "otp_type")
    private String otp_type;
    @Column(name = "otp")
    private String otp;
    @Column(name = "otp_expiry_time")
    private LocalDateTime otp_expiry_time;
    @OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "unique_id")
    private User user;
    @Column(name = "reg_key")
    private UUID reg_key=UUID.randomUUID();
    @Column(name = "email_verified")
    private boolean email_verified;

}







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
    @Column(name = "userAttribute_id")
    private int id;
    @Column(name = "otp_type")
    private String otp_type;
    @Column(name = "otp_expiry_date")
    private String otp_expiry_date;
    @OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private User user;
}







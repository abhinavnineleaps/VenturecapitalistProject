package com.platform.VentureCapitalist.repository;

import com.platform.VentureCapitalist.model.UserAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserAttributeRepository extends JpaRepository<UserAttribute,Integer> {
    @Query("select u from UserAttribute u where u.registrationKey = ?1 ")
    UserAttribute findByRegistrationKey(UUID registrationKey);
//        UserAttribute findByRegistrationKey(String registrationKey);






}

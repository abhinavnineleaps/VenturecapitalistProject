package com.platform.VentureCapitalist.repository;

import com.platform.VentureCapitalist.model.VentureCapitalistDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VentureCapitalistDetailsRepository extends JpaRepository<VentureCapitalistDetails,Integer> {

    @Modifying
    @Query("UPDATE User e SET e.registered = :registered ")
    void updateFieldById(@Param("registered") String registered);
}

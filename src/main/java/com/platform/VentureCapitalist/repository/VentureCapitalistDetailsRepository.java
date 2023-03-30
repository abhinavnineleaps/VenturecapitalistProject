package com.platform.VentureCapitalist.repository;

import com.platform.VentureCapitalist.model.VentureCapitalistDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentureCapitalistDetailsRepository extends JpaRepository<VentureCapitalistDetails,Integer> {
}

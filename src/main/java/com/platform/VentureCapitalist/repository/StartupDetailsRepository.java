package com.platform.VentureCapitalist.repository;

import com.platform.VentureCapitalist.model.StartupDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StartupDetailsRepository extends JpaRepository<StartupDetails,Integer> {
}

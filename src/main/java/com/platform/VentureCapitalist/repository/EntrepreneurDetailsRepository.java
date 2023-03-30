package com.platform.VentureCapitalist.repository;

import com.platform.VentureCapitalist.model.EntrepreneurDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepreneurDetailsRepository extends JpaRepository<EntrepreneurDetails,Integer> {
}

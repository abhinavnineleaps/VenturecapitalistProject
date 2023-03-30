package com.platform.VentureCapitalist.repository;

import com.platform.VentureCapitalist.model.UserAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAttributeRepository extends JpaRepository<UserAttribute,Integer> {
}

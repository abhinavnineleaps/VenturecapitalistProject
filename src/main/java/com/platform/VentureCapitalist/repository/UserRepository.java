package com.platform.VentureCapitalist.repository;

import com.platform.VentureCapitalist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

  //Query for searching
  @Query("SELECT p FROM User p WHERE " +
          "p.name LIKE CONCAT('%',:query, '%')" +
          "Or p.email LIKE CONCAT('%', :query, '%')")
  List<User> searchUser(String query);

}

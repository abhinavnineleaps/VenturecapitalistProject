package com.platform.VentureCapitalist.repository;

import com.platform.VentureCapitalist.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

  @Query("select u from User u where u.email = ?1 and u.registered=true")
  User findByEmailAddressAndIsRegister(String emailAddress);

//
//  @Query("select u from User u where u.registered = ?1 ")
//  User findByRegistrationKeyVc(UUID registrationKey);

  @Modifying
  @Transactional
  @Query("update User u set u.registered=true where u.userId=?1")
  void updateRegistrationStatus(int id);


}

package com.planbtech.prostudy.repositories;

import com.planbtech.prostudy.entities.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users WHERE useremail = ?1 AND userpassword = ?2", nativeQuery = true)
    User login(String email, String password);
}

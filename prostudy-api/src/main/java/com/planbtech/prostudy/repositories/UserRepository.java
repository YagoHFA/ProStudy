package com.planbtech.prostudy.repositories;

import com.planbtech.prostudy.entities.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query(value = "SELECT * FROM users WHERE useremail = ?1 AND userpassword = ?2", nativeQuery = true)
    Optional<User> login(String email, String password);

    @Query(value = "SELECT * FROM users WHERE username = ?1", nativeQuery = true)
    User findByUserName(String test);

    @Transactional
    @Modifying
    @Query("update User u set u.userName = ?1 where u.userId = ?2")
    int updateUserNameByUserId(String userName, Long userId);
}

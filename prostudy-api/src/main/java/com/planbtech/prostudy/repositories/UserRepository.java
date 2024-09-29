package com.planbtech.prostudy.repositories;

import com.planbtech.prostudy.entities.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select uu from Users uu " +
            " left join fetch uu.skillTests " +
            " left join fetch uu.userProjects " +
            " left join fetch uu.userRole " +
            " where uu.userName = :userName")
    Optional<User> findAllInfo(@Param("userName") String userName);

    @Query(value = "select u from Users u " +
            " left join fetch u.userRole " +
            " where u.userName = :userName")
    Optional<User> findByUserName(String userName);

    @Query(value = "select u from Users u " +
            " left join fetch u.userRole " +
            " where u.userName = :userEmail")
    Optional<User> findByUserEmail(String userEmail);
}

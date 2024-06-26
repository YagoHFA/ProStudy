package com.planbtech.prostudy.repositories;

import com.planbtech.prostudy.entities.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

    Role findByRoleName(String name);

}

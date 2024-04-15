package com.planbtech.prostudy.repositories;

import com.planbtech.prostudy.entities.model.SkillTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<SkillTest, String>{

}

package com.planbtech.prostudy.repositories;

import com.planbtech.prostudy.DTO.ProjectDTO.ProjectMinViewDTO;
import com.planbtech.prostudy.entities.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

    @Query(value = "select p from Project p left join fetch p.projectsUser o where o.userName = :userName")
    List<Project> findByOwner(@Param("userName") String userName);
}

package com.planbtech.prostudy.repositories;

import com.planbtech.prostudy.entities.model.Project;
import com.planbtech.prostudy.entities.model.User_Project;
import com.planbtech.prostudy.entities.model.User_ProjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProjectRepository  extends JpaRepository<User_Project, User_ProjectId> {

    List<Project> findById_UserId_UserName(String userName);
}

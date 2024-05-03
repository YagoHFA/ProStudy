package com.planbtech.prostudy.services.interfaces;

import com.planbtech.prostudy.DTO.ProjectDTO.ProjectAddDTO;
import com.planbtech.prostudy.DTO.SkillTestDTO.TestCompleteDTO;
import com.planbtech.prostudy.DTO.UserDTO.UserDTO;
import com.planbtech.prostudy.config.security.DTO.UserRegisterDTO;
import com.planbtech.prostudy.entities.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IUserServices {
    void createUser(UserRegisterDTO userToCreate);

    Optional<User> findByUserName(String userName);

    UserDTO update(UserDTO user);

    void testConclusion(Long userid, String testid);

    void createCompany(UserRegisterDTO userToRegister);

    void addProject(ProjectAddDTO projectDTO);

    void completeTest(TestCompleteDTO testCompleteDTO);
}

package com.planbtech.prostudy.services.interfaces;

import com.planbtech.prostudy.DTO.ProjectDTO.ProjectAddDTO;
import com.planbtech.prostudy.DTO.ProjectDTO.ProjectToSendDTO;
import com.planbtech.prostudy.DTO.SkillTestDTO.TestCompleteDTO;
import com.planbtech.prostudy.DTO.UserDTO.UserDTO;
import com.planbtech.prostudy.DTO.UserDTO.UserLoadDTO;
import com.planbtech.prostudy.component.security.DTO.UserRegisterDTO;
import com.planbtech.prostudy.entities.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserServices {

    void createUser(UserRegisterDTO userToCreate);

    Optional<User> findByUserName(String userName);

    UserDTO update(UserDTO user);

    void createCompany(UserRegisterDTO userToRegister);

    void addProject(ProjectAddDTO projectDTO);

    void completeTest(TestCompleteDTO testCompleteDTO);

    UserLoadDTO loadUser(String userName);

    void sendProject(ProjectToSendDTO projectToSendDTO);

    void CheckUserCreate  (String userName);
}

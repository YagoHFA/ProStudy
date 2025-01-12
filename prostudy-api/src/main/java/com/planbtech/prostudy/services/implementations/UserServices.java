package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.DTO.ProjectDTO.ProjectAddDTO;
import com.planbtech.prostudy.DTO.ProjectDTO.ProjectToSendDTO;
import com.planbtech.prostudy.DTO.SkillTestDTO.TestCompleteDTO;
import com.planbtech.prostudy.DTO.UserDTO.UserDTO;
import com.planbtech.prostudy.DTO.UserDTO.UserLoadDTO;
import com.planbtech.prostudy.component.Exception.ClassException.SecurityException.RoleNotFound;
import com.planbtech.prostudy.component.Exception.ClassException.UserException.UserAddProjectError;
import com.planbtech.prostudy.component.Exception.ClassException.UserException.UserCreateError;
import com.planbtech.prostudy.component.Exception.ClassException.UserException.UserNotFound;
import com.planbtech.prostudy.component.security.DTO.UserRegisterDTO;
import com.planbtech.prostudy.component.security.service.TokenService;
import com.planbtech.prostudy.entities.model.*;
import com.planbtech.prostudy.repositories.*;
import com.planbtech.prostudy.services.interfaces.IUserServices;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServices implements IUserServices {

  @Autowired
  private TokenService tokenService;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private TestRepository testRepository;

  @Autowired
  private ProjectRepository projectRepository;

  @Autowired
  private CategoryReporitory categoryRepository;

  @Transactional
  @Override
  public void createUser(UserRegisterDTO userToRegister) {
    String encodedPassword = new BCryptPasswordEncoder().encode(userToRegister.password());
    User userToSave = User.builder()
        .userName(userToRegister.userName())
        .userPassword(encodedPassword)
        .userEmail(userToRegister.email())
        .userRole(Collections.singletonList(roleRepository.findByRoleName("USER")
            .orElseThrow(() -> new RoleNotFound("Role not found in creating user"))))
        .build();
    userRepository.save(userToSave);
  }

  @Override
  @Transactional
  public Optional<User> findByUserName(String userName) {
    return userRepository.findByUserName(userName);
  }

  @Transactional
    @Override
    public UserDTO update(UserDTO user) {
        return userRepository.findById(user.getUserId()).map((x -> new UserDTO(userRepository.save(x)))).orElseThrow(()
        -> new UserNotFound("User to update not found")
    }

  @Transactional
  @Override
  public void createCompany(UserRegisterDTO userToRegister) {
    String encodedPassword = new BCryptPasswordEncoder().encode(userToRegister.password());
    User userToSave = User.builder()
        .userName(userToRegister.userName())
        .userPassword(encodedPassword)
        .userEmail(userToRegister.email())
        .userRole(Collections.singletonList(roleRepository.findByRoleName("Company")
            .orElseThrow(() -> new RoleNotFound("Role not found in creating company"))))
        .build();
    userRepository.save(userToSave);
  }

  @Transactional
  @Override
  public void addProject(ProjectAddDTO projectDTO) {
    User user = userRepository
        .findByUserName(projectDTO.getProjectOwner())
        .orElseThrow(() -> new UserNotFound("User not found in add project"));

    Project project = Project.builder()
        .projectName(projectDTO.getProjectName())
        .projectURL(projectDTO.getProjectURL())
        .projectDescription(projectDTO.getShortDescription())
        .build();
    project.generateProjectId(project.getProjectName(), user.getUsername(), user.getUserId());
    user.getUserProjects().add(project);

    try {
      userRepository.save(user);
    } catch (Exception e) {
      throw new UserAddProjectError("Error on associate a project to a user");
    }
  }

  @Transactional
  @Override
  public void completeTest(TestCompleteDTO testCompleteDTO) {
    User userToComplete = userRepository
        .findByUserName(testCompleteDTO.getUserName())
        .orElseThrow(() -> new UserNotFound("User not found in complete test"));

    userToComplete.getSkillTests().add(testRepository.findById(testCompleteDTO
        .getTestId()).orElseThrow());
    userRepository.save(userToComplete);
  }

  @Transactional
  @Override
  public UserLoadDTO loadUser(String userName) {

    User user = userRepository.findByUserName(userName).orElseThrow();

    return new UserLoadDTO(user);
  }

  @Transactional
    @Override
    public void sendProject(ProjectToSendDTO projectToSendDTO) {
        throw new RuntimeException("Method to be implemented");
    }<<<<<<<HEAD

  @Transactional
    @Override
    public void CheckUserCreate  (String userName) throws UserCreateError {
         if (userRepository.findByUserName(userName).isPresent()){
             throw new UserCreateError("User already exists");
        };
    }=======>>>>>>>main
}

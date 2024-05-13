package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.DTO.ProjectDTO.ProjectAddDTO;
import com.planbtech.prostudy.DTO.SkillTestDTO.TestCompleteDTO;
import com.planbtech.prostudy.DTO.UserDTO.UserDTO;
import com.planbtech.prostudy.DTO.UserDTO.UserLoadDTO;
import com.planbtech.prostudy.config.security.DTO.UserRegisterDTO;
import com.planbtech.prostudy.config.security.service.TokenService;
import com.planbtech.prostudy.entities.model.Project;
import com.planbtech.prostudy.entities.model.User;
import com.planbtech.prostudy.entities.model.User_Project;
import com.planbtech.prostudy.entities.model.User_ProjectId;
import com.planbtech.prostudy.repositories.*;
import com.planbtech.prostudy.services.interfaces.IUserServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

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
                .userRole(Collections.singletonList(roleRepository.findByRoleName("USER")))
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
        -> new RuntimeException("Usuario não encontrado")
        );
    }

    @Transactional
    @Override
    public void createCompany(UserRegisterDTO userToRegister) {
        String encodedPassword = new BCryptPasswordEncoder().encode(userToRegister.password());
        User userToSave = User.builder()
                .userName(userToRegister.userName())
                .userPassword(encodedPassword)
                .userEmail(userToRegister.email())
                .userRole(Collections.singletonList(roleRepository.findByRoleName("Company")))
                .build();
        userRepository.save(userToSave);
    }

    @Transactional
    @Override
    public void addProject(ProjectAddDTO projectDTO) {
        String username = tokenService.validateToken(projectDTO.getProjectOwner());
        User user = userRepository.findByUserName(username).orElseThrow();
        user.getUserProjects().add(
                User_Project.builder()
                        .id(
                                User_ProjectId
                                        .builder()
                                        .userId(user)
                                        .projectId(Project
                                                .builder()
                                                .projectName(projectDTO.getProjectName())
                                                .projectDescription(projectDTO.getShortdescription())
                                                .tools(projectDTO
                                                        .getTools()
                                                        .stream()
                                                        .map(categoryRepository::findByCategoryName)
                                                        .toList())
                                                .projectURL(projectDTO.getProjectURL())
                                                .build())
                                        .build()

        )
                        .permission("Owner")
                        .build()
        );
    }

    @Transactional
    @Override
    public void completeTest(TestCompleteDTO testCompleteDTO) {
        User userToComplete = userRepository.findByUserName(testCompleteDTO.getUserName()).orElseThrow();
        userToComplete.getSkillTests().add(testRepository.findById(testCompleteDTO.getTestId()).orElseThrow());
        userRepository.save(userToComplete);
    }

    @Transactional
    @Override
    public UserLoadDTO loadUser(String userName) {
        System.out.println("UserName: " + userName);
        User user = userRepository.findByUserName(userName).orElseThrow();
        System.out.println("Email: " + user.getUserEmail());
        user.getUserRole().forEach(x-> {
            System.out.println("Role: " + x.getRoleName());
        });
        user.getSkillTests().forEach(x-> {
            System.out.println("Test: " + x.getTestTitle());
        });
        return userRepository.findByUserName(userName).map(UserLoadDTO::new).orElseThrow();
    }
}

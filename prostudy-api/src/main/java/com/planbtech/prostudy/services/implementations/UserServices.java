package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.DTO.UserDTO;
import com.planbtech.prostudy.config.security.DTO.UserRegisterDTO;
import com.planbtech.prostudy.entities.model.Role;
import com.planbtech.prostudy.entities.model.User;
import com.planbtech.prostudy.repositories.RoleRepository;
import com.planbtech.prostudy.repositories.TestRepository;
import com.planbtech.prostudy.repositories.UserRepository;
import com.planbtech.prostudy.services.interfaces.IUserServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices implements IUserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TestRepository testRepository;

    @Transactional
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
    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }


    @Transactional
    public UserDTO update(UserDTO user) {
        return userRepository.findById(user.getUserId()).map((x -> new UserDTO(userRepository.save(x)))).orElseThrow(()
        -> new RuntimeException("Usuario não encontrado")
        );
    }

    @Override
    public void testConclusion(Long userid, String testid) {
        User userToUpdate = userRepository.findById(userid).orElseThrow();
        userToUpdate.getSkillTests().add(testRepository.findById(testid).orElseThrow());
        userRepository.save(userToUpdate);
    }

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
}

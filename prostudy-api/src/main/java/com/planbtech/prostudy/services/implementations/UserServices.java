package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.DTO.UserDTO;
import com.planbtech.prostudy.component.Mapper;
import com.planbtech.prostudy.entities.model.User;
import com.planbtech.prostudy.repositories.RoleRepository;
import com.planbtech.prostudy.repositories.UserRepository;
import com.planbtech.prostudy.services.interfaces.IUserServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements IUserServices {

    private Mapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public void createUser(UserDTO userToCreate) {
        User user = mapper.ofDTO(userToCreate);
        user.getUserRole().add(roleRepository.findByRoleName("USER"));
        userRepository.save(user);
    }


    @Transactional
    public UserDTO update(UserDTO user) {
        return userRepository.findById(user.getUserId()).map((x -> new UserDTO(userRepository.save(x)))).orElseThrow(()
        -> new RuntimeException("Usuario não encontrado")
        );
    }


}

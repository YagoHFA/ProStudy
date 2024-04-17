package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.DTO.UserDTO;
import com.planbtech.prostudy.entities.model.User;
import com.planbtech.prostudy.repositories.UserRepository;
import com.planbtech.prostudy.services.interfaces.IUserServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices implements IUserServices {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserDTO createUser(User userToCreate) {
        return new UserDTO(userRepository.save(userToCreate));
    }

    @Override
    @Transactional
    public UserDTO login(String email, String password) {
        return userRepository.login(email, password)
                .map(UserDTO::new)
                .orElseThrow(
                () -> new RuntimeException("Usuario não encontrado")
        );
    }


    @Override
    @Transactional
    public UserDTO update(User user) {
        return userRepository.findById(user.getUserId()).map((x -> new UserDTO(userRepository.save(x)))).orElseThrow(()
        -> new RuntimeException("Usuario não encontrado")
        );

    }
}

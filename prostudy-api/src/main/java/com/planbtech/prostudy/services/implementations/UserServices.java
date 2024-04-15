package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.DTO.UserDTO;
import com.planbtech.prostudy.entities.model.User;
import com.planbtech.prostudy.repositories.UserRepository;
import com.planbtech.prostudy.services.interfaces.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements IUserServices {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User userToCreate) {
        userRepository.save(userToCreate);
    }

    @Override
    public User login(String email, String password) {
        return userRepository.login(email, password);
    }
}

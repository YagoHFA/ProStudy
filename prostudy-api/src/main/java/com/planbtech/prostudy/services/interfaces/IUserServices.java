package com.planbtech.prostudy.services.interfaces;

import com.planbtech.prostudy.DTO.UserDTO;
import com.planbtech.prostudy.entities.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserServices {
    UserDTO createUser(User userToCreate);

    UserDTO login(String email, String password);

    UserDTO update(User user);
}

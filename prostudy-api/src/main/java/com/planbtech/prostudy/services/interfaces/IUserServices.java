package com.planbtech.prostudy.services.interfaces;

import com.planbtech.prostudy.DTO.UserDTO;
import com.planbtech.prostudy.entities.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserServices {
    void createUser(UserDTO userToCreate);

    UserDTO login(String email, String password);

    UserDTO update(UserDTO user);
}

package com.planbtech.prostudy.services.interfaces;

import com.planbtech.prostudy.DTO.UserDTO;
import com.planbtech.prostudy.entities.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserServices {
    void createUser(User userToCreate);

    User login(String email, String password);
}

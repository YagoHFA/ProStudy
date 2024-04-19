package com.planbtech.prostudy.component;

import com.planbtech.prostudy.DTO.UserDTO;
import com.planbtech.prostudy.entities.model.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public User ofDTO(UserDTO userDTO) {
        return new User(userDTO.getUserId(), userDTO.getUserName(), userDTO.getUserEmail(), userDTO.getUserPassword());
    }
}

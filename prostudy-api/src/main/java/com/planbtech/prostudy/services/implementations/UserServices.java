package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.DTO.UserDTO;
import com.planbtech.prostudy.component.Mapper;
import com.planbtech.prostudy.repositories.UserRepository;
import com.planbtech.prostudy.services.interfaces.IUserServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements IUserServices {

    private Mapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void createUser(UserDTO userToCreate) {
        JdbcUserDetailsManager test = new JdbcUserDetailsManager();
        UserDetails usertes = User.builder()
                .username(userToCreate.getUserName())
                .password(userToCreate.getUserPassword())
                .roles("User").build();
        test.createUser(usertes);
         mapper.ofDTO(userToCreate);
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
    public UserDTO update(UserDTO user) {
        return userRepository.findById(user.getUserId()).map((x -> new UserDTO(userRepository.save(x)))).orElseThrow(()
        -> new RuntimeException("Usuario não encontrado")
        );

    }
}

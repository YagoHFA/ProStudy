package com.planbtech.prostudy.config.security.service;

import com.planbtech.prostudy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Loaduser: " + username);

        return userRepository
                .findByUserName(username)
                .orElse(userRepository.findByUserEmail(username)
                        .orElseThrow(()-> new UsernameNotFoundException("Usuario não encontrado")));

    }
}

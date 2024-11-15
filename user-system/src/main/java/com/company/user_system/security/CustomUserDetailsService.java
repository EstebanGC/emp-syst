package com.company.user_system.security;

import com.company.user_system.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository= userRepository;
    }

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user  = userRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("Invalid username or password"));
//
//        return new org.springframework.security.core.userdetails.User(
//          user.getEmail(),
//                user.getPassword(),
//                map
//        );
//
//
//    }
}

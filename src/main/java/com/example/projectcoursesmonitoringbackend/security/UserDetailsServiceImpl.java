package com.example.projectcoursesmonitoringbackend.security;

import com.example.projectcoursesmonitoringbackend.exception.NotFoundException;
import com.example.projectcoursesmonitoringbackend.model.User;
import com.example.projectcoursesmonitoringbackend.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private static final String USER_NOT_FOUND_EXCEPTION_MESSAGE = "User was not found by Email ";

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new NotFoundException(USER_NOT_FOUND_EXCEPTION_MESSAGE + email));
        return new UserDetailsImpl(user);
    }
}

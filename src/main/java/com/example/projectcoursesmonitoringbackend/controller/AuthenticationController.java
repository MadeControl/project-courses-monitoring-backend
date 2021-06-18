package com.example.projectcoursesmonitoringbackend.controller;

import com.example.projectcoursesmonitoringbackend.dto.AuthenticationDTO;
import com.example.projectcoursesmonitoringbackend.security.JwtProvider;
import com.example.projectcoursesmonitoringbackend.security.JwtToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    public AuthenticationController(AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationDTO authenticationDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(), authenticationDTO.getPassword()));
        log.info("Authentication: {}", authentication.getName());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwtToken(authentication);
        log.info("Generate token: {}", jwt);
        UserDetails userDetails =  (UserDetails) authentication.getPrincipal();
        log.info("UserDetails: {}", userDetails.getUsername());
        return ResponseEntity.ok(new JwtToken(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }

}

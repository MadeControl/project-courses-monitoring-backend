package com.example.projectcoursesmonitoringbackend.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JwtToken {
    private String token;
    private String username;
    private Collection<? extends GrantedAuthority> authorities;
}

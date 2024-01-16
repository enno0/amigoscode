package com.amogoscode.enno.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
    private String username;
    private String password;
    private List<String> roles;

    @Override
    public UserDetails loadUserByUsername(String username2) throws UsernameNotFoundException {
        try {
            this.username = jdbcTemplate.queryForObject(
                    "SELECT user_name FROM user_api WHERE user_name = ?",
                    new Object[] { username2 },
                    String.class);
        } catch (EmptyResultDataAccessException e) {
            logger.warn("No user found with username: {}", username2);
            throw new UsernameNotFoundException("User not found with username: " + username2);
        }

        try {
            this.password = jdbcTemplate.queryForObject(
                    "SELECT password FROM user_api WHERE user_name = ?",
                    new Object[] { username2 },
                    String.class);
        } catch (EmptyResultDataAccessException e) {
            logger.error("No password found for user: {}", username2, e);
            throw new UsernameNotFoundException("User not found with username: " + username2);
        }

        try {
            this.roles = jdbcTemplate.queryForList(
                    "SELECT role FROM user_role_api WHERE user_name = ?",
                    new Object[] { username2 },
                    String.class);
        } catch (EmptyResultDataAccessException e) {
            logger.error("No roles found for user: {}", username2, e);
            throw new UsernameNotFoundException("User not found with username: " + username2);
        }

        return User.withUsername(
                username) // Corrected to use method parameter
                .password(passwordEncoder().encode(password))
                .roles(roles.toArray(new String[0]))
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
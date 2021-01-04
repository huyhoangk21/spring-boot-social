package com.huyhoang.instagram.service;

import com.huyhoang.instagram.dto.SignupRequest;
import com.huyhoang.instagram.exception.ResourceAlreadyExistsException;
import com.huyhoang.instagram.model.User;
import com.huyhoang.instagram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User signup(SignupRequest signupRequest) throws ResourceAlreadyExistsException {

        Map<String, String> errors = new HashMap<>();
        if(userRepository.existsByUsername(signupRequest.getUsername())) {
            errors.put("username", "Username already exists");
        }

        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            errors.put("email", "Email already exists");
        }
        if (!errors.isEmpty()) {
            throw new ResourceAlreadyExistsException(errors);
        }

        User user = new User(signupRequest.getUsername(),
                signupRequest.getEmail(),
                passwordEncoder.encode(signupRequest.getPassword()));

        userRepository.save(user);

        return user;
    }
}

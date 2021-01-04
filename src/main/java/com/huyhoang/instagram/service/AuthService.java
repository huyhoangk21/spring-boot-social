package com.huyhoang.instagram.service;

import com.huyhoang.instagram.dto.SignupRequest;
import com.huyhoang.instagram.exception.ResourceAlreadyExistsException;
import com.huyhoang.instagram.model.User;
import com.huyhoang.instagram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        ResourceAlreadyExistsException ex = new ResourceAlreadyExistsException();

        if(userRepository.existsByUsername(signupRequest.getUsername())) {
            ex.addError("username");
        }

        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            ex.addError("email");
        }

        if (!ex.getErrors().isEmpty()) {
            throw ex;
        }

        User user = new User(signupRequest.getUsername(),
                signupRequest.getEmail(),
                passwordEncoder.encode(signupRequest.getPassword()));

        userRepository.save(user);

        return user;
    }
}

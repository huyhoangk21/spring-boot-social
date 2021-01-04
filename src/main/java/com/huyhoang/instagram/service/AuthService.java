package com.huyhoang.instagram.service;

import com.huyhoang.instagram.dto.SignupRequest;
import com.huyhoang.instagram.exception.EmailAlreadyExistsException;
import com.huyhoang.instagram.exception.UsernameAlreadyExistsException;
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
    public User signup(SignupRequest signupRequest) {

        if(userRepository.existsByUsername(signupRequest.getUsername())) {
            throw new UsernameAlreadyExistsException(
                    String.format("Username %s already exists", signupRequest.getUsername()));
        }

        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            throw new EmailAlreadyExistsException(
                    String.format("Email %s already exists", signupRequest.getEmail()));
        }

        User user = new User(signupRequest.getUsername(),
                signupRequest.getEmail(),
                passwordEncoder.encode(signupRequest.getPassword()));

        userRepository.save(user);

        return user;
    }
}

package com.huyhoang.instagram.service;

import com.huyhoang.instagram.model.User;
import com.huyhoang.instagram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getAllUsersWithUsernames(List<String> usernames) {
        return userRepository.findByUsernameIn(usernames);
    }
}

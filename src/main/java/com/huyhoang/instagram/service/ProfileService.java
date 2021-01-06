package com.huyhoang.instagram.service;

import com.huyhoang.instagram.model.Profile;
import com.huyhoang.instagram.model.User;
import com.huyhoang.instagram.repository.ProfileRepository;
import com.huyhoang.instagram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }
}

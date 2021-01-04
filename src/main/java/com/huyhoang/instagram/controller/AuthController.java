package com.huyhoang.instagram.controller;

import com.huyhoang.instagram.dto.ApiResponse;
import com.huyhoang.instagram.dto.SignupRequest;
import com.huyhoang.instagram.model.User;
import com.huyhoang.instagram.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthController {

    Logger log = LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(path = "/signup")
    public ResponseEntity<ApiResponse<User>> signup(@Valid @RequestBody SignupRequest signupRequest) {
        User user = authService.signup(signupRequest);
        ApiResponse<User> response = new ApiResponse<>(HttpStatus.CREATED,
                "Register successful",
                Collections.singletonList(user));
        return new ResponseEntity<> (response, HttpStatus.CREATED);
    }
}

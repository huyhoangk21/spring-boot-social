package com.huyhoang.instagram.controller;

import com.huyhoang.instagram.dto.SignupRequest;
import com.huyhoang.instagram.model.User;
import com.huyhoang.instagram.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(path = "/signup")
    public ResponseEntity<User> signup(@Valid @RequestBody SignupRequest signupRequest) {
        User user = authService.signup(signupRequest);
        return ResponseEntity.ok(user);
    }
}

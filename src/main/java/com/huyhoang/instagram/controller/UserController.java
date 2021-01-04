package com.huyhoang.instagram.controller;

import com.huyhoang.instagram.dto.ApiResponse;
import com.huyhoang.instagram.model.User;
import com.huyhoang.instagram.service.UserService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<ApiResponse<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        ApiResponse<User> response = new ApiResponse<>(HttpStatus.OK, "Get all user successful", users);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

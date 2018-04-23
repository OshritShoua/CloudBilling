package com.cloudbilling.backend.controller;


import com.cloudbilling.backend.Exceptions.UserCreationException;
import com.cloudbilling.backend.entity.User;
import com.cloudbilling.backend.entity.security.Role;
import com.cloudbilling.backend.entity.security.UserRole;
import com.cloudbilling.backend.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;


@RestController
public class RestResource {


    @Autowired
    private UserService userService;

    @RequestMapping("/signup")
    public ResponseEntity<String> signUserUp(@RequestBody User user)
    {
        ResponseEntity<String> responseResult = ResponseEntity.status(HttpStatus.OK).body("");

        System.out.println(user);
        Set<UserRole> userRoles = new HashSet<>();
        Role role = new Role();
        role.setName("ROLE_USER");
        userRoles.add(new UserRole(user, role));
        try {
            userService.createUser(user, userRoles);
        } catch (UserCreationException e) {
            responseResult = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return responseResult;
    }

    @RequestMapping("/login")
    public String login()
    {
        return "login...";
    }
}

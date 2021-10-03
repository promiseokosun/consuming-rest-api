package com.techblazer.consumingrestapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techblazer.consumingrestapi.service.GithubUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class GithubUserController {

    @Autowired
    private GithubUserService githubUserService;

    @GetMapping
    public ResponseEntity<?> getUsers() {
        ResponseEntity<String> usersStr = githubUserService.getUsers();


        return new ResponseEntity<>(usersStr, HttpStatus.OK);
    }

    @GetMapping("{username}")
    public ResponseEntity<?> getUser(@PathVariable("username") String username) {
        Object user = null;
        try {
            user = githubUserService.getUserByUsername(username);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}

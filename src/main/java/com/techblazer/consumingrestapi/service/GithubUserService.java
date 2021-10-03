package com.techblazer.consumingrestapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface GithubUserService {

    ResponseEntity<String> getUsers();

    Object getUserByUsername(String username) throws JsonProcessingException;
}

package com.techblazer.consumingrestapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;


public interface GithubUserService {

    Object getUsers();

    Object getUsersV2();

    Object getUserByUsername(String username) throws JsonProcessingException;


    Object getUserByUsernameV2(String username) throws JsonProcessingException;
}

package com.techblazer.consumingrestapi.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.techblazer.consumingrestapi.dto.BaseResponse;
import com.techblazer.consumingrestapi.dto.UserRes;
import com.techblazer.consumingrestapi.dto.UserResponse;
import com.techblazer.consumingrestapi.service.GithubUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;
import static com.techblazer.consumingrestapi.constant.ApiConstants.GITHUB_USER_API;
//import static com.techblazer.consumingrestapi.constant.ApiConstants.GITHUB_USER_API;

@Service
@Slf4j
public class GithubUserServiceImpl implements GithubUserService {

    @Autowired
    private RestTemplate restTemplate;

    Gson gson = new Gson();


    @Override
    public Object getUsers() {
        ResponseEntity<String> response = restTemplate.getForEntity(GITHUB_USER_API.getUrl(), String.class);

        List<UserResponse> userResponses = new ArrayList<>();
        if (response.getStatusCodeValue() == 200) {
            log.info("successful: {}", response);
            String bodyJson = response.getBody();
            List<Map<String, Object>> users = gson.fromJson(bodyJson, ArrayList.class);

            for (Map user : users) {
                String name = String.valueOf(user.get("name"));
                String company = String.valueOf(user.get("company"));
                String email = String.valueOf(user.get("email"));
                String location = String.valueOf(user.get("location"));

                // set all this to our response object
                UserResponse userResponse = new UserResponse();
                userResponse.setName(name);
                userResponse.setCompany(company);
                userResponse.setEmail(email);
                userResponse.setLocation(location);

                userResponses.add(userResponse);
            }

            return userResponses;
        }

        log.info("The Response: {}", response);

        return null;
    }

    @Override
    public Object getUsersV2() {

        ResponseEntity<String> response = restTemplate.getForEntity(GITHUB_USER_API.getUrl(), String.class);

        if (response.getStatusCodeValue() == 200) {
            log.info("successful: {}", response);
            String bodyJson = response.getBody();
            List<UserRes> users = gson.fromJson(bodyJson, ArrayList.class);
            return users;
        }

        log.info("The Response: {}", response);

        return null;
    }

    @Override
    public Object getUserByUsername(String username) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.getForEntity(GITHUB_USER_API.getUrl() +"/"+ username, String.class);

//        ObjectMapper mapper = new ObjectMapper();


        if (response.getStatusCodeValue() == 200) {
            String bodyJson = response.getBody();
//            Map<String, Object> userMap = mapper.readValue(bodyJson, HashMap.class);
            Map<String, Object> userMap = gson.fromJson(bodyJson, HashMap.class);
            String name = String.valueOf(userMap.get("name"));
            String company = String.valueOf(userMap.get("company"));
            String email = String.valueOf(userMap.get("email"));
            String location = String.valueOf(userMap.get("location"));

            // set all this to our response object
            UserResponse userResponse = new UserResponse();
            userResponse.setName(name);
            userResponse.setCompany(company);
            userResponse.setEmail(email);
            userResponse.setLocation(location);

            log.info("{}", userResponse);
            return userResponse;
        }

        // request was not successful

        return null;
    }

    @Override
    public Object getUserByUsernameV2(String username) throws JsonProcessingException {
        return null;
    }


}

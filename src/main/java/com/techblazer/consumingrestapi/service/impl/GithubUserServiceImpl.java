package com.techblazer.consumingrestapi.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.techblazer.consumingrestapi.dto.UserResponse;
import com.techblazer.consumingrestapi.service.GithubUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;
import static com.techblazer.consumingrestapi.constant.ApiConstants.GITHUB_USER_API;

@Service
@Slf4j
public class GithubUserServiceImpl implements GithubUserService {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public ResponseEntity<String> getUsers() {
        ResponseEntity<String> response = restTemplate.getForEntity(GITHUB_USER_API, String.class);

        if (response.getStatusCodeValue() == 200) {
            log.info("successful: {}", response);

        }

        log.info("The Response: {}", response);

        return response;
    }

    @Override
    public Object getUserByUsername(String username) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.getForEntity(GITHUB_USER_API +"/"+ username, String.class);

//        ObjectMapper mapper = new ObjectMapper();
        Gson gson = new Gson();

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


}

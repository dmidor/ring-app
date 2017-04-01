package com.ring.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ring.security.AuthorizedUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserController {

    protected String getUserID() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        AuthorizedUser details = (AuthorizedUser) authentication.getDetails();
        return details.getUserId();
    }

    protected JsonNode getResponse(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(obj , JsonNode.class);
    };

}

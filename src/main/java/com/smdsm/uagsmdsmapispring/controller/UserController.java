package com.smdsm.uagsmdsmapispring.controller;

import com.smdsm.uagsmdsmapispring.DTO.UserDto;
import com.smdsm.uagsmdsmapispring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping
    ResponseEntity<List<UserDto>> getUsers(){

        HttpStatus httpStatus = HttpStatus.OK;
        List<UserDto> users = new ArrayList<>();

        try {
            users = userService.findAll();
        }
        catch (Exception e) {
            log.error("There was an error with the current request.", e);
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity(users, httpStatus);
    }

    @GetMapping("/{userId}")
    ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){

        HttpStatus httpStatus = HttpStatus.OK;
        UserDto user = new UserDto();

        try {
            user = userService.getById(userId);
        }
        catch (Exception e) {
            log.error("There was an error with the current request.", e);
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity(user, httpStatus);
    }
}

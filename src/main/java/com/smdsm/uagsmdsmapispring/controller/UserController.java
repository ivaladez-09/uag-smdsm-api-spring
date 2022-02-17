package com.smdsm.uagsmdsmapispring.controller;

import com.smdsm.uagsmdsmapispring.DTO.UserDto;
import com.smdsm.uagsmdsmapispring.persistence.entity.User;
import com.smdsm.uagsmdsmapispring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    List<UserDto> getUsers(){
        return userService.findAll();
    }
}

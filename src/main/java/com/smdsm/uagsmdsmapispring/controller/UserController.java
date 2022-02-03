package com.smdsm.uagsmdsmapispring.controller;

import com.smdsm.uagsmdsmapispring.persistence.entity.User;
import com.smdsm.uagsmdsmapispring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    List<User> getUser(){
        //List<User> userByGender = userService.findByGender("male");
        //Optional<User> userById = userService.findById(1);
        List<User> users = userService.findAll();
        return users;
    }
}

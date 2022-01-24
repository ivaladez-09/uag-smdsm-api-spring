package com.smdsm.uagsmdsmapispring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController("user")
public class UserController {

    @GetMapping("/all")
    @ResponseBody
    String getUser(){

        return "ok";
    }
}

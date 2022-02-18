package com.smdsm.uagsmdsmapispring.controller;

import com.smdsm.uagsmdsmapispring.DTO.UserDto;
import com.smdsm.uagsmdsmapispring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping
    ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
        UserDto user = userService.findById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto savedUserDto = userService.create(userDto);
        return new ResponseEntity<>(savedUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    ResponseEntity<UserDto> updateUserById(@Valid @RequestBody UserDto userDto,
                                           @PathVariable Integer userId){
        UserDto updatedUserDto = userService.update(userDto, userId);
        return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    ResponseEntity<String> deleteUserById(@PathVariable Integer userId){
        userService.deleteById(userId);
        return new ResponseEntity<>("User entity deleted successfully.", HttpStatus.OK);
    }
}

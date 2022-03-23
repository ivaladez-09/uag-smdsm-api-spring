package com.smdsm.uagsmdsmapispring.controller;

import com.smdsm.uagsmdsmapispring.dto.UserDto;
import com.smdsm.uagsmdsmapispring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<UserDto> getUserById(@PathVariable Integer id){
        UserDto user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto savedUserDto = userService.create(userDto);
        return new ResponseEntity<>(savedUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<UserDto> updateUserById(
            @Valid @RequestBody UserDto userDto,
            @PathVariable Integer id){
        UserDto updatedUserDto = userService.update(userDto, id);
        return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteUserById(@PathVariable Integer id){
        userService.deleteById(id);
        return new ResponseEntity<>(
                "User entity deleted successfully.",
                HttpStatus.OK);
    }

    @GetMapping("/count-disease") // ?disease={}&gender={}
    ResponseEntity<Integer> countUsersByDisease(
            @RequestParam(
                    value = "disease",
                    defaultValue = "diabetes",
                    required = false) String disease,
            @RequestParam(
                    value = "gender",
                    defaultValue = "male",
                    required = false) String gender){

        Integer totalUsers = userService.countUsersByGenderAndDisease(
                gender,
                disease
        );
        return new ResponseEntity<>(totalUsers, HttpStatus.OK);
    }

    @GetMapping("/count-risk-factor") // ?riskFactor={}&gender={}
    ResponseEntity<Integer> countUsersByRiskFactor(
            @RequestParam(
                    value = "riskFactor",
                    defaultValue = "hdl",
                    required = false) String riskFactor,
            @RequestParam(
                    value = "gender",
                    defaultValue = "female",
                    required = false) String gender){

        Integer totalUsers = userService.countUsersByGenderAndRiskFactor(
                gender,
                riskFactor
        );
        return new ResponseEntity<>(totalUsers, HttpStatus.OK);
    }

    @GetMapping("/count-date-range") // ?startDate={}&endDate={}&gender={}
    ResponseEntity<Integer> countUsersByDateRange(
            @RequestParam(
                    value = "startDate",
                    defaultValue = "1900-01-01",
                    required = false) String startDate,
            @RequestParam(
                    value = "endDate",
                    defaultValue = "2099-12-31",
                    required = false) String endDate,
            @RequestParam(
                    value = "gender",
                    defaultValue = "female",
                    required = false) String gender){

        Integer totalUsers = userService.countByGenderAndBirthdayBetween(
                gender,
                startDate,
                endDate
        );
        return new ResponseEntity<>(totalUsers, HttpStatus.OK);
    }
}

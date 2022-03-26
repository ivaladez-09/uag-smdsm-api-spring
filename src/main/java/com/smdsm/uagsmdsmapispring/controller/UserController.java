package com.smdsm.uagsmdsmapispring.controller;

import com.smdsm.uagsmdsmapispring.dto.UserDto;
import com.smdsm.uagsmdsmapispring.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    final UserService service;

    @GetMapping
    ResponseEntity<List<UserDto>> getAll(){
        List<UserDto> users = service.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<UserDto> getById(@PathVariable Integer id){
        UserDto user = service.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<UserDto> create(@Valid @RequestBody UserDto userDto){
        UserDto savedUserDto = service.create(userDto);
        return new ResponseEntity<>(savedUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<UserDto> updateById(
            @Valid @RequestBody UserDto userDto,
            @PathVariable Integer id
    ){
        UserDto updatedUserDto = service.update(userDto, id);
        return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteById(@PathVariable Integer id){
        service.deleteById(id);
        return new ResponseEntity<>(
                "User entity deleted successfully.",
                HttpStatus.OK);
    }

    @GetMapping("/count-disease") // ?disease={}&gender={}
    ResponseEntity<Integer> countByDisease(
            @RequestParam(
                    value = "disease",
                    defaultValue = "diabetes",
                    required = false) String disease,
            @RequestParam(
                    value = "gender",
                    defaultValue = "male",
                    required = false) String gender
    ){
        Integer totalUsers = service.countByGenderAndDisease(
                gender,
                disease
        );
        return new ResponseEntity<>(totalUsers, HttpStatus.OK);
    }

    @GetMapping("/count-risk-factor") // ?riskFactor={}&gender={}
    ResponseEntity<Integer> countByRiskFactor(
            @RequestParam(
                    value = "riskFactor",
                    defaultValue = "hdl",
                    required = false) String riskFactor,
            @RequestParam(
                    value = "gender",
                    defaultValue = "female",
                    required = false) String gender
    ){
        Integer totalUsers = service.countByGenderAndRiskFactor(
                gender,
                riskFactor
        );
        return new ResponseEntity<>(totalUsers, HttpStatus.OK);
    }

    @GetMapping("/count-date-range") // ?startDate={}&endDate={}&gender={}
    ResponseEntity<Integer> countByDateRange(
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
                    required = false) String gender
    ){
        Integer totalUsers = service.countByGenderAndBirthdayBetween(
                gender,
                startDate,
                endDate
        );
        return new ResponseEntity<>(totalUsers, HttpStatus.OK);
    }
}

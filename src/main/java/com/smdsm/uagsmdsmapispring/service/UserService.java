package com.smdsm.uagsmdsmapispring.service;

import com.smdsm.uagsmdsmapispring.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(Integer id);
    UserDto create(UserDto userDto);
    UserDto update(UserDto userDto, Integer id);
    void deleteById(Integer id);
    Integer countByGenderAndRiskFactor(String riskFactor, String gender);
    Integer countByGenderAndDisease(String disease, String gender);
    Integer countByGenderAndBirthdayBetween(String gender, String startDate, String endDate);
}

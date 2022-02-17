package com.smdsm.uagsmdsmapispring.service;

import com.smdsm.uagsmdsmapispring.DTO.UserDto;
import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(Integer id);
}

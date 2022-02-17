package com.smdsm.uagsmdsmapispring.service;

import com.smdsm.uagsmdsmapispring.DTO.UserDto;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> findAll();

}

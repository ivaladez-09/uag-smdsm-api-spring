package com.smdsm.uagsmdsmapispring.service;

import com.smdsm.uagsmdsmapispring.DTO.UserDto;
import com.smdsm.uagsmdsmapispring.persistence.entity.User;
import com.smdsm.uagsmdsmapispring.persistence.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> mapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto getById(Integer id) {
        User user = userRepository.getById(id);
        return mapper.map(user, UserDto.class);
    }
}

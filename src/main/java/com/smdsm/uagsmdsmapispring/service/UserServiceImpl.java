package com.smdsm.uagsmdsmapispring.service;

import com.smdsm.uagsmdsmapispring.dto.UserDto;
import com.smdsm.uagsmdsmapispring.exception.ResourceNotFoundException;
import com.smdsm.uagsmdsmapispring.persistence.entity.User;
import com.smdsm.uagsmdsmapispring.persistence.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
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
    public UserDto findById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return mapper.map(user, UserDto.class);
    }

    @Override
    public UserDto create(UserDto userDto) {
        User user = mapper.map(userDto, User.class);
        User newUser = userRepository.save(user);
        return mapper.map(newUser, UserDto.class);
    }

    @Override
    public UserDto update(UserDto userDto, Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setGender(userDto.getGender());
        user.setBirthday(userDto.getBirthday());
        userRepository.save(user);

        return mapper.map(user, UserDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.deleteById(id);
    }

    @Override
    public Integer countUsersByGenderAndRiskFactor(String riskFactor, String gender) {
        if (riskFactor == null || riskFactor.isEmpty()){
            log.error("Parameter 'riskFactor' must not be null or empty.");
        }
        return 0;
    }

    @Override
    public Integer countUsersByGenderAndDisease(String disease, String gender) {
        if (disease == null || disease.isEmpty()){
            log.error("Parameter 'disease' must not be null or empty.");
        }
        return 0;
    }
}

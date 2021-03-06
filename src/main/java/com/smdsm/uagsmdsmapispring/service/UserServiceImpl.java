package com.smdsm.uagsmdsmapispring.service;

import com.smdsm.uagsmdsmapispring.dto.UserDto;
import com.smdsm.uagsmdsmapispring.exception.ResourceNotFoundException;
import com.smdsm.uagsmdsmapispring.persistence.entity.User;
import com.smdsm.uagsmdsmapispring.persistence.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private ModelMapper mapper;

    //NOTE: Inject dependencies on this way to create Unit Testing. Avoid @Autowired UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

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
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.deleteById(id);
    }

    @Override
    public Integer countUsersByGenderAndRiskFactor(String gender, String riskFactor) {
        log.info(riskFactor + " and " + gender);
        return userRepository.countByGenderAndRiskFactor(gender, riskFactor);
    }

    @Override
    public Integer countUsersByGenderAndDisease(String gender, String disease) {
        log.info(disease + " and " + gender);
        return userRepository.countByGenderAndDisease(gender, disease);
    }

    @Override
    public Integer countByGenderAndBirthdayBetween(String gender, String startDate, String endDate) {
        log.info(startDate + ", " + endDate + ", and " + gender);
        return userRepository.countByGenderAndBirthdayBetween(gender, LocalDate.parse(startDate), LocalDate.parse(endDate));
    }
}

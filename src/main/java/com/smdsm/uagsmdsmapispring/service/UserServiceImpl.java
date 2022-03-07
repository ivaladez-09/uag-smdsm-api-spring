package com.smdsm.uagsmdsmapispring.service;

import com.smdsm.uagsmdsmapispring.dto.UserDto;
import com.smdsm.uagsmdsmapispring.exception.ResourceNotFoundException;
import com.smdsm.uagsmdsmapispring.persistence.entity.UserEntity;
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
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream().map(user -> mapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return mapper.map(userEntity, UserDto.class);
    }

    @Override
    public UserDto create(UserDto userDto) {
        UserEntity userEntity = mapper.map(userDto, UserEntity.class);
        UserEntity newUserEntity = userRepository.save(userEntity);
        return mapper.map(newUserEntity, UserDto.class);
    }

    @Override
    public UserDto update(UserDto userDto, Integer id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setGender(userDto.getGender());
        userEntity.setBirthday(userDto.getBirthday());
        userRepository.save(userEntity);

        return mapper.map(userEntity, UserDto.class);
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

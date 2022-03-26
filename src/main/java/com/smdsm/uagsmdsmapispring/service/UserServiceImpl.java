package com.smdsm.uagsmdsmapispring.service;

import com.smdsm.uagsmdsmapispring.dto.UserDto;
import com.smdsm.uagsmdsmapispring.exception.ResourceNotFoundException;
import com.smdsm.uagsmdsmapispring.persistence.entity.UserEntity;
import com.smdsm.uagsmdsmapispring.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor //NOTE: Inject dependencies on this way. Avoid @Autowired
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<UserDto> findAll() {
        List<UserEntity> userEntities = repository.findAll();
        return userEntities
                .stream()
                .map(user -> mapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(final Integer id) {
        UserEntity user = repository
                .findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User", "id", id)
                );
        return mapper.map(user, UserDto.class);
    }

    @Override
    public UserDto create(final UserDto userDto) {
        UserEntity newUser = repository.save(
                mapper.map(userDto, UserEntity.class)
        );
        return mapper.map(newUser, UserDto.class);
    }

    @Override
    public UserDto update(final UserDto userDto, final Integer id) {
        UserEntity user = repository
                .findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User", "id", id)
                );

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setGender(userDto.getGender());
        user.setBirthday(userDto.getBirthday());
        repository.save(user);

        return mapper.map(user, UserDto.class);
    }

    @Override
    public void deleteById(final Integer id) {
        repository
                .findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User", "id", id)
                );
        repository.deleteById(id);
    }

    @Override
    public Integer countByGenderAndRiskFactor(final String gender, final String riskFactor) {
        log.info(riskFactor + " and " + gender);
        return repository.countByGenderAndRiskFactor(gender, riskFactor);
    }

    @Override
    public Integer countByGenderAndDisease(final String gender, final String disease) {
        log.info(disease + " and " + gender);
        return repository.countByGenderAndDisease(gender, disease);
    }

    @Override
    public Integer countByGenderAndBirthdayBetween(
            final String gender,
            final String startDate,
            final String endDate) {
        log.info(startDate + ", " + endDate + ", and " + gender);
        return repository.countByGenderAndBirthdayBetween(
                gender,
                LocalDate.parse(startDate),
                LocalDate.parse(endDate)
        );
    }
}

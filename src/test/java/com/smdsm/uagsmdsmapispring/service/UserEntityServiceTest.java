package com.smdsm.uagsmdsmapispring.service;

import com.smdsm.uagsmdsmapispring.dto.UserDto;
import com.smdsm.uagsmdsmapispring.persistence.entity.UserEntity;
import com.smdsm.uagsmdsmapispring.persistence.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserEntityServiceTest {

    @Mock
    private UserRepository userRepository;
    private List<UserDto> expectedAllUsersDto;
    private final Function<String, LocalDate> parser = LocalDate::parse;
    private final ModelMapper mapper = new ModelMapper();

    @InjectMocks
    private final UserService userService = new UserServiceImpl(userRepository, mapper);

    @BeforeEach
    public void setup(){
        expectedAllUsersDto = Arrays.asList(
                new UserDto(1, "Ivan", "Valadez", "male", parser.apply("1996-02-09")),
                new UserDto(2, "Aaron", "Ruiz", "male", parser.apply("2000-06-20")),
                new UserDto(3, "Susana", "Perez", "female", parser.apply("1998-05-08")),
                new UserDto(4, "Andrea", "Amante", "female", parser.apply("2001-07-22")),
                new UserDto(5, "Raul", "Rios", "male", parser.apply("1985-11-30"))
        );
    }

    @Test
    void findAll() {
        when(userRepository.findAll()).thenReturn(
                Arrays.asList(
                        new UserEntity(1, "Ivan", "Valadez", "male", parser.apply("1996-02-09")),
                        new UserEntity(2, "Aaron", "Ruiz", "male", parser.apply("2000-06-20")),
                        new UserEntity(3, "Susana", "Perez", "female", parser.apply("1998-05-08")),
                        new UserEntity(4, "Andrea", "Amante", "female", parser.apply("2001-07-22")),
                        new UserEntity(5, "Raul", "Rios", "male", parser.apply("1985-11-30"))
                )
        );
        List<UserDto> actualUsers = userService.findAll();
        assertEquals(expectedAllUsersDto, actualUsers);
    }

    @Test
    void findById() {
        when(userRepository.findById(1)).
                thenReturn(Optional.of(
                        new UserEntity(1, "Ivan", "Valadez", "male", parser.apply("1996-02-09"))
                ));
        Optional<UserEntity> actualUser = userRepository.findById(1);
        assertFalse(actualUser.isEmpty());
    }

    @Test
    void create() {
        UserEntity userEntity = new UserEntity(1, "Ivan", "Valadez", "male", parser.apply("1996-02-09"));
        when(userRepository.save(any())).thenReturn(userEntity);
        UserDto expectedUser = mapper.map(userEntity, UserDto.class);

        UserDto actualUser = userService.create(new UserDto(1, "Ivan", "Valadez", "male", parser.apply("1996-02-09")));
        assertEquals(expectedUser, actualUser);
    }

    @Test
    void update() {
        UserEntity userEntity = new UserEntity(1, "Ivan", "Valadez", "male", parser.apply("1996-02-09"));
        when(userRepository.findById(1)).
                thenReturn(Optional.of(userEntity));
        UserDto expectedUser = mapper.map(userEntity, UserDto.class);

        UserDto actualUser = userService.update(expectedUser, expectedUser.getId());
        assertEquals(expectedUser, actualUser);
    }

    @Test
    void countUsersByGenderAndRiskFactor() {
        when(userRepository.countByGenderAndRiskFactor("male", "hdl")).thenReturn(5);

        Integer result = userService.countUsersByGenderAndRiskFactor("male", "hdl");
        assertEquals(5, result);
    }

    @Test
    void countUsersByGenderAndDisease() {
        when(userRepository.countByGenderAndDisease("female", "diabetes")).thenReturn(5);

        Integer result = userService.countUsersByGenderAndDisease("female", "diabetes");
        assertEquals(5, result);
    }

    @Test
    void countByGenderAndBirthdayBetween() {
        LocalDate startDate = parser.apply("1996-02-09");
        LocalDate endDate = parser.apply("2002-06-07");
        when(userRepository.countByGenderAndBirthdayBetween("female", startDate, endDate)).thenReturn(5);

        Integer result = userService.countByGenderAndBirthdayBetween("female", "1996-02-09", "2002-06-07");
        assertEquals(5, result);
    }
}
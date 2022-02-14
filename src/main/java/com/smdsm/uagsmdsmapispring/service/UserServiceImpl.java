package com.smdsm.uagsmdsmapispring.service;

import com.smdsm.uagsmdsmapispring.persistence.entity.User;
import com.smdsm.uagsmdsmapispring.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findByGender(String gender) {
        return userRepository.findByGender(gender);
    }

    @Override
    public List<User> findByGenderAndBirthdayBetween(String gender, LocalDateTime startDate, LocalDateTime endDate) {
        return userRepository.findByGenderAndBirthdayBetween(gender, startDate, endDate);
    }
}

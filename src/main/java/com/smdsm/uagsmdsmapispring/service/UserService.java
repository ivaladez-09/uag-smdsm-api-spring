package com.smdsm.uagsmdsmapispring.service;

import com.smdsm.uagsmdsmapispring.persistence.entity.User;
import com.smdsm.uagsmdsmapispring.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findByGender(String gender){
        return userRepository.findByGender(gender);
    }
    public Optional<User> findById(Integer id){
        return userRepository.findById(id);
    }
    public List<User> findByGenderAndBirthdayBetween(String gender, LocalDateTime startDate, LocalDateTime endDate){
        return userRepository.findByGenderAndBirthdayBetween(gender, startDate, endDate);
    }
    public List<User> findAll(){
        List<User> users = userRepository.findAll();
        return users;
    }

}

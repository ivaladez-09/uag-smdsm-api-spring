package com.smdsm.uagsmdsmapispring.service;

import com.smdsm.uagsmdsmapispring.persistence.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> findAll();
    Optional<User> findById(Integer id);
    List<User> findByGender(String gender);
    List<User> findByGenderAndBirthdayBetween(String gender, LocalDateTime startDate, LocalDateTime endDate);

}

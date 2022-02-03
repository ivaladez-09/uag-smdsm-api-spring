package com.smdsm.uagsmdsmapispring.persistence.repository;

import com.smdsm.uagsmdsmapispring.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findByGender(String gender);
    public Optional<User> findById(Integer id);
    public List<User> findByGenderAndBirthdayBetween(String gender, LocalDateTime startDate, LocalDateTime endDate);
}

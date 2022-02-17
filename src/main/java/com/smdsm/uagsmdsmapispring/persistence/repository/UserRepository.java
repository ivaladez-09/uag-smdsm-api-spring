package com.smdsm.uagsmdsmapispring.persistence.repository;

import com.smdsm.uagsmdsmapispring.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findByGenderAndBirthdayBetween(String gender, LocalDate startDate, LocalDate endDate);
    /*public List<User> findByGenderAndDisease(String gender, String disease);
    public List<User> findByGenderAndRiskFactor(String gender, String riskFactor);*/
}

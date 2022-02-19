package com.smdsm.uagsmdsmapispring.persistence.repository;

import com.smdsm.uagsmdsmapispring.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findByGenderAndBirthdayBetween(String gender, LocalDate startDate, LocalDate endDate);

    @Query(value = "SELECT COUNT(*) FROM User u\n" +
            "        INNER JOIN UserDisease ud ON ud.userId=u.id\n" +
            "        INNER JOIN Disease d ON ud.diseaseId=d.id\n" +
            "        WHERE gender = :gender AND name = :disease", nativeQuery = true)
    public Integer findByGenderAndDisease(@Param("gender") String gender, @Param("disease") String disease);

    @Query(value = "SELECT COUNT(*) FROM User u\n" +
            "        INNER JOIN UserRiskFactor ur ON ur.userId=u.id\n" +
            "        INNER JOIN RiskFactor r ON ur.riskFactorId=r.id\n" +
            "        WHERE gender = :gender AND name = :riskFactor", nativeQuery = true)
    public Integer findByGenderAndRiskFactor(@Param("gender") String gender, @Param("riskFactor") String riskFactor);
}

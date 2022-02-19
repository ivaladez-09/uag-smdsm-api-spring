package com.smdsm.uagsmdsmapispring.persistence.repository;

import com.smdsm.uagsmdsmapispring.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findByGenderAndBirthdayBetween(String gender, LocalDate startDate, LocalDate endDate);

    @Query(value = "SELECT COUNT(*) FROM public.user u\n" +
            "        INNER JOIN public.user_disease ud ON ud.id_user=u.id\n" +
            "        INNER JOIN public.disease d ON ud.id_disease=d.id\n" +
            "        WHERE gender = :gender AND name = :disease", nativeQuery = true)
    public Integer findByGenderAndDisease(@Param("gender") String gender, @Param("disease") String disease);

    @Query(value = "SELECT COUNT(*) FROM public.user u\n" +
            "        INNER JOIN public.user_risk_factor ur ON ur.id_user=u.id\n" +
            "        INNER JOIN public.risk_factor r ON ur.id_risk_factor=r.id\n" +
            "        WHERE gender = :gender AND name = :riskFactor", nativeQuery = true)
    public Integer findByGenderAndRiskFactor(@Param("gender") String gender, @Param("riskFactor") String riskFactor);
}

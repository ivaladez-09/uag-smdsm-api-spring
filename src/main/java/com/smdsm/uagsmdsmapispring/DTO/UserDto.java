package com.smdsm.uagsmdsmapispring.DTO;

import com.smdsm.uagsmdsmapispring.persistence.entity.UserDisease;
import com.smdsm.uagsmdsmapispring.persistence.entity.UserRiskFactor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate birthday;
    List<UserDiseaseDto> userDiseases;
    List<UserRiskFactorDto> userRiskFactors;
}

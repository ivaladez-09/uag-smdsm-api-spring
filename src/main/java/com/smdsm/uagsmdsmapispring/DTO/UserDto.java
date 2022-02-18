package com.smdsm.uagsmdsmapispring.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;
    @NotEmpty
    @Size(min = 3, message = "First name should have at least 3 characters")
    private String firstName;
    private String lastName;
    @NotEmpty
    @Size(min = 4, message = "Gender should have at least 4 characters - male/female")
    private String gender;
    @NotEmpty
    private LocalDate birthday;
    List<UserDiseaseDto> userDiseases;
    List<UserRiskFactorDto> userRiskFactors;
}

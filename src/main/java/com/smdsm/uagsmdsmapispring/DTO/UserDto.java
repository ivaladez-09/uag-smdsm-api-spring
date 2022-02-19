package com.smdsm.uagsmdsmapispring.DTO;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private LocalDate birthday;
    private List<UserDiseaseDto> userDiseases;
    private List<UserRiskFactorDto> userRiskFactors;
}

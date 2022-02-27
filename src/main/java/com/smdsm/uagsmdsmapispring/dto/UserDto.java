package com.smdsm.uagsmdsmapispring.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserDto implements Serializable {
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

    public UserDto(Integer id, String firstName, String lastName, String gender, LocalDate birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
    }
}

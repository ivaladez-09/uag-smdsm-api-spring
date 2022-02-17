package com.smdsm.uagsmdsmapispring.DTO;

import com.smdsm.uagsmdsmapispring.persistence.entity.Disease;
import com.smdsm.uagsmdsmapispring.persistence.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDiseaseDto {
    private Integer id;
    private Boolean isActive;
    DiseaseDto disease;
}

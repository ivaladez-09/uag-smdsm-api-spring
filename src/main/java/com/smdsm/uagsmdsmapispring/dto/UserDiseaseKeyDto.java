package com.smdsm.uagsmdsmapispring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDiseaseKeyDto {
    private Integer userId;
    private Integer diseaseId;
}
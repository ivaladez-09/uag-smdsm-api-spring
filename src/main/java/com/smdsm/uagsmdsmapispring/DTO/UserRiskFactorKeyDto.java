package com.smdsm.uagsmdsmapispring.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRiskFactorKeyDto {
    private Integer userId;
    private Integer riskFactorId;
}

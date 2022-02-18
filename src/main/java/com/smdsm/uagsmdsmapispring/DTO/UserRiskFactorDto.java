package com.smdsm.uagsmdsmapispring.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRiskFactorDto {
    private UserRiskFactorKeyDto id;
    private Boolean isActive;
    private Integer value;
    private RiskFactorDto riskFactor;
}

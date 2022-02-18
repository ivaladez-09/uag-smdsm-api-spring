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
    //private Integer id;
    private Boolean isActive;
    private Integer value;
    RiskFactorDto riskFactor;
}

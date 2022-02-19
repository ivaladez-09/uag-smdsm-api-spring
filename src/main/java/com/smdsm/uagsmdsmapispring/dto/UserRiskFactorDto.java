package com.smdsm.uagsmdsmapispring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRiskFactorDto implements Serializable {
    private UserRiskFactorKeyDto id;
    private Boolean isActive;
    private Integer value;
    private RiskFactorDto riskFactor;
}

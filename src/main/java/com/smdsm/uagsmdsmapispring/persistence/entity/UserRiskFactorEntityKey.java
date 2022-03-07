package com.smdsm.uagsmdsmapispring.persistence.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class UserRiskFactorEntityKey implements Serializable {
    @Column(name = "id_user", nullable = false)
    private Integer userId;

    @Column(name = "id_risk_factor", nullable = false)
    private Integer riskFactorId;
}

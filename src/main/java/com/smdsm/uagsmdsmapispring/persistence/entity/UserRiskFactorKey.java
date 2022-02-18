package com.smdsm.uagsmdsmapispring.persistence.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class UserRiskFactorKey implements Serializable {
    @Column(name = "id_user")
    private Integer userId;

    @Column(name = "id_risk_factor")
    private Integer riskFactorId;
}

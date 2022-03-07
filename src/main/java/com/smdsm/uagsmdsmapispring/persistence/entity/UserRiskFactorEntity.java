package com.smdsm.uagsmdsmapispring.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_risk_factor")
public class UserRiskFactorEntity implements Serializable {

    @EmbeddedId
    private UserRiskFactorEntityKey id;

    @Column(name = "active", nullable = false)
    private Boolean isActive = false;

    @Column(name = "rate", nullable = false)
    private Integer rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "id_user")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("riskFactorId")
    @JoinColumn(name = "id_risk_factor")
    private RiskFactorEntity riskFactor;
}

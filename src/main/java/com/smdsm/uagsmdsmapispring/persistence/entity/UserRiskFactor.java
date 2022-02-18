package com.smdsm.uagsmdsmapispring.persistence.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_risk_factor", schema = "public")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class UserRiskFactor {

    @EmbeddedId
    private UserRiskFactorKey id;

    @Column(name = "active")
    private Boolean isActive;

    @Column(name = "value")
    private Integer value;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @MapsId("riskFactorId")
    @JoinColumn(name = "id_risk_factor")
    private RiskFactor riskFactor;
}

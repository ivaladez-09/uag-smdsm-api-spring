package com.smdsm.uagsmdsmapispring.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_risk_factor")
public class UserRiskFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "id_risk_factor")
    private Integer idRiskFactor;

    @Column(name = "active")
    private Integer isActive;

    @ManyToOne
    @MapsId(value = "idUser")
    @JoinColumn(name = "id_user")
    User user;

    @ManyToOne
    @MapsId(value = "idRiskFactor")
    @JoinColumn(name = "id_risk_factor")
    RiskFactor riskFactor;
}

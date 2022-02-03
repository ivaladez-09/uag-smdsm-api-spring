package com.smdsm.uagsmdsmapispring.persistence.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"user", "riskFactor"})
@ToString(exclude = {"user"})
@Entity
@Table(name = "user_risk_factor", schema = "public")
public class UserRiskFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /*@Column(name = "id_user")
    private Integer idUser;

    @Column(name = "id_risk_factor")
    private Integer idRiskFactor;*/

    @Column(name = "active")
    private Integer isActive;

    @Column(name = "value")
    private Integer value;

    @ManyToOne
    @JoinColumn(name = "id_user")
    User user;

    @ManyToOne
    @JoinColumn(name = "id_risk_factor")
    RiskFactor riskFactor;
}

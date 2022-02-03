package com.smdsm.uagsmdsmapispring.persistence.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(exclude = {"userRiskFactors"})
@ToString(exclude = {"userRiskFactors"})
@Entity
@Table(name = "risk_factor", schema = "public")
public class RiskFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "riskFactor")
    List<UserRiskFactor> userRiskFactors = new ArrayList<>();
}

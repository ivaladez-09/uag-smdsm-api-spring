package com.smdsm.uagsmdsmapispring.persistence.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
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
    @ToString.Exclude
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("riskFactorId")
    @JoinColumn(name = "id_risk_factor")
    @ToString.Exclude
    private RiskFactorEntity riskFactor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserRiskFactorEntity that = (UserRiskFactorEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

package com.smdsm.uagsmdsmapispring.persistence.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_disease")
public class UserDiseaseEntity implements Serializable {

    @EmbeddedId
    private UserDiseaseEntityKey id;

    @Column(name = "active", nullable = false)
    private Boolean isActive = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "id_user")
    @ToString.Exclude
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("diseaseId")
    @JoinColumn(name = "id_disease")
    @ToString.Exclude
    private DiseaseEntity disease;
}

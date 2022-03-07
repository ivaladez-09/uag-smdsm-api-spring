package com.smdsm.uagsmdsmapispring.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_disease")
public class UserDiseaseEntity implements Serializable {

    @EmbeddedId
    private UserDiseaseEntityKey id;

    @Column(name = "active")
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "id_user")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("diseaseId")
    @JoinColumn(name = "id_disease")
    private DiseaseEntity disease;
}

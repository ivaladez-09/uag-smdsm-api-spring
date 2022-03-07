package com.smdsm.uagsmdsmapispring.persistence.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class UserDiseaseEntityKey implements Serializable {
    @Column(name = "id_user")
    private Integer userId;

    @Column(name = "id_disease")
    private Integer diseaseId;
}

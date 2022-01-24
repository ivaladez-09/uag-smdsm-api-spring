package com.smdsm.uagsmdsmapispring.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_disease")
public class UserDisease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "id_disease")
    private Integer idDisease;

    @Column(name = "active")
    private Boolean isActive;

    @ManyToOne
    @MapsId(value = "idUser")
    @JoinColumn(name = "id_user")
    User user;

    @ManyToOne
    @MapsId(value = "idDisease")
    @JoinColumn(name = "id_disease")
    Disease disease;
}

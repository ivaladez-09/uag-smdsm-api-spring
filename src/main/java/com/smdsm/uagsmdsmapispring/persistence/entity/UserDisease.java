package com.smdsm.uagsmdsmapispring.persistence.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"user", "disease"})
@ToString(exclude = {"user"})
@Entity
@Table(name = "user_disease", schema = "public")
public class UserDisease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /*@Column(name = "id_user")
    private Integer idUser;

    @Column(name = "id_disease")
    private Integer idDisease;*/

    @Column(name = "active")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "id_user")
    User user;

    @ManyToOne
    @JoinColumn(name = "id_disease")
    Disease disease;
}

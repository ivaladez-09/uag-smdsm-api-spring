package com.smdsm.uagsmdsmapispring.persistence.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(exclude = {"userDiseases", "userRiskFactors"})
@ToString(exclude = {"userDiseases", "userRiskFactors"})
@Entity
@Table(name = "user", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthday")
    private LocalDateTime birthday;

    @OneToMany(mappedBy = "user")
    List<UserDisease> userDiseases = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<UserRiskFactor> userRiskFactors = new ArrayList<>();
}

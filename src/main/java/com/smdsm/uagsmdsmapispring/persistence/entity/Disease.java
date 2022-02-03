package com.smdsm.uagsmdsmapispring.persistence.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(exclude = {"userDiseases"})
@ToString(exclude = {"userDiseases"})
@Entity
@Table(name = "disease", schema = "public")
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "disease")
    List<UserDisease> userDiseases = new ArrayList<>();
}

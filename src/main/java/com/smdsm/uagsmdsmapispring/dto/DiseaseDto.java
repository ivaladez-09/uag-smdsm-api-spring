package com.smdsm.uagsmdsmapispring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiseaseDto implements Serializable {
    private Integer id;
    private String name;
}

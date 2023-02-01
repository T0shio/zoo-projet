package com.example.projetzoo.models.dtos.animals;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimalDto {

    private Integer id;
    private String fullName;
    private String sex;
    private String species;
}

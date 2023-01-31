package com.example.projetzoo.models.dtos.animals;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
public class AnimalsDto {

    private Integer id;
    private String fullName;
    private String sex;
    private String species;
}

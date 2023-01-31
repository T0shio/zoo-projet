package com.example.projetzoo.models.dtos.areas;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AreasDto {
    private Integer id;
    private String name;
    private String environment;
}

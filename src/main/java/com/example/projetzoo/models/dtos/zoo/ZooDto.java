package com.example.projetzoo.models.dtos.zoo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ZooDto {
    private Integer id;
    private String name;
    private String address;
}

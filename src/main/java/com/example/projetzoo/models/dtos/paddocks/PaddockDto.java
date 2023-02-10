package com.example.projetzoo.models.dtos.paddocks;

import jakarta.annotation.sql.DataSourceDefinition;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PaddockDto {
    private int id;
    private int maxCapacity;
}

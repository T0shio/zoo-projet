package com.example.projetzoo.models.dtos.employees;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class EmployeesDto {
    private Integer id;
    private String fullName;
    private String jobName;

}

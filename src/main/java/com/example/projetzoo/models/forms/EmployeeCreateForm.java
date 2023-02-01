package com.example.projetzoo.models.forms;

import com.example.projetzoo.models.entities.Area;
import com.example.projetzoo.models.entities.Employee;
import lombok.Data;


import java.util.ArrayList;
@Data
public class EmployeeCreateForm {
    private String lastName;
    private String firstName;
    private String jobName;
    private Area area;

    public Employee toBll() {
        Employee entity = new Employee();
        entity.setFirstName(firstName);
        entity.setLastName(lastName);
        entity.setJobName(jobName);
        entity.setAreas(new ArrayList<>());
        entity.setAnimals(new ArrayList<>());
        return entity;
    }
}

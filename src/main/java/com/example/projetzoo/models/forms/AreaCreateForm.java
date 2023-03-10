package com.example.projetzoo.models.forms;

import com.example.projetzoo.models.entities.Area;
import lombok.Data;


import java.util.ArrayList;


@Data
public class AreaCreateForm {
    private long zooId;
    private String name;
    private String environment;

    public Area toBll() {
        Area entity = new Area();
        entity.setName(name);
        entity.setEnvironment(environment);
        entity.setEmployees(new ArrayList<>());
        entity.setAnimals(new ArrayList<>());
        return entity;
    }
}
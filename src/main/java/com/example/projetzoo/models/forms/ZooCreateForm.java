package com.example.projetzoo.models.forms;


import com.example.projetzoo.models.entities.Zoo;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ZooCreateForm {
    private String name;
    private String address;
    private long areaId;
    public Zoo toBll() {
        Zoo entity = new Zoo();
        entity.setName(name);
        entity.setAddress(address);
        entity.setAnimals(new ArrayList<>());
        entity.setProviders(new ArrayList<>());
        return entity;
    }
}

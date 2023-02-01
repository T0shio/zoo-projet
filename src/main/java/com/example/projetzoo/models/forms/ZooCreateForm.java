package com.example.projetzoo.models.forms;

import com.example.projetzoo.models.entities.Area;
import com.example.projetzoo.models.entities.Provider;
import com.example.projetzoo.models.entities.Zoo;

import java.util.ArrayList;

public class ZooCreateForm {
    private String name;
    private String address;
    private Area area;
    public Zoo toBll() {
        Zoo entity = new Zoo();
        entity.setName(name);
        entity.setAddress(address);
        entity.setAreas(new ArrayList<>());
        return entity;
    }
}

package com.example.projetzoo.models.forms;

import com.example.projetzoo.models.entities.Animal;
import com.example.projetzoo.models.entities.Area;
import lombok.Data;

import java.util.ArrayList;
@Data
public class AnimalCreateForm {
    private long areaId;
    private String name;
    private String species;
    private String sex;
    public Animal toBll(){
        Animal entity = new Animal();
        entity.setName(name);
        entity.setSpecies(species);
        entity.setSex(sex);
        return entity;
    }
}

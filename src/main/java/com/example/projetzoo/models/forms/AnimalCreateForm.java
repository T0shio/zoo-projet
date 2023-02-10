package com.example.projetzoo.models.forms;

import com.example.projetzoo.models.entities.Animal;
import com.example.projetzoo.models.entities.Area;
import lombok.Data;

import java.util.ArrayList;
@Data
public class AnimalCreateForm {
    private long areaId;
    private long paddockId;
    private String paddocks;
    private String name;
    private String species;
    private String sex;
    private Area areas;
    public Animal toBll(){
        Animal entity = new Animal();
        entity.setName(name);
        entity.setSpecies(species);
        entity.setSex(sex);
        entity.setAreas(areas);
        entity.setPaddock(paddocks);
        return entity;
    }
}

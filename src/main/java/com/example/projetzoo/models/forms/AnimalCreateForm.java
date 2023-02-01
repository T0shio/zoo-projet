package com.example.projetzoo.models.forms;

import com.example.projetzoo.models.entities.Animal;
import com.example.projetzoo.models.entities.Area;

import java.util.ArrayList;

public class AnimalCreateForm {
    private String name;
    private String species;
    private String sex;
    public Animal toBll(){
        Animal entity = new Animal();
        entity.setName(name);
        entity.setSpecies(species);
        entity.setSex(sex);
        entity.setArea(new Area());
        entity.setEmployees(new ArrayList<>());
        return entity;
    }
}
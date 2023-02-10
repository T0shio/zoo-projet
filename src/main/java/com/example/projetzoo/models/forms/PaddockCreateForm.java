package com.example.projetzoo.models.forms;

import com.example.projetzoo.models.entities.Animal;
import com.example.projetzoo.models.entities.Area;
import com.example.projetzoo.models.entities.Employee;
import com.example.projetzoo.models.entities.Paddock;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaddockCreateForm {
        private Long areaId;
        private int maxCapacity;
        private Area area;
        private List<Animal> animals;
        public Paddock toBll() {
            Paddock entity = new Paddock();
            entity.setMaxCapacity(maxCapacity);
            entity.setAreas(area);
            entity.setAnimals(animals);
            return entity;
        }
    }


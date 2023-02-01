package com.example.projetzoo.services.animal;

import com.example.projetzoo.models.entities.Animal;
import com.example.projetzoo.repositories.AnimalRepository;
import com.example.projetzoo.services.CrudServiceImpl;

public class AnimalServiceImpl extends CrudServiceImpl<AnimalRepository, Animal, Integer> implements AnimalService {
    protected AnimalServiceImpl(AnimalRepository animalRepository) {
        super(animalRepository);
    }
}

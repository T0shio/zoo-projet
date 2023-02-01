package com.example.projetzoo.services.animal;

import com.example.projetzoo.models.entities.Animal;
import com.example.projetzoo.services.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface AnimalService extends CrudService<Animal, Integer> {
}

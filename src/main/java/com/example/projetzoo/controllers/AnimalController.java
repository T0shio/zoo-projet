package com.example.projetzoo.controllers;


import com.example.projetzoo.exceptions.HttpNotFoundException;
import com.example.projetzoo.models.entities.Animal;
import com.example.projetzoo.services.animal.AnimalService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = {"/animal"})
public class AnimalController implements BaseRestController<Animal, Integer> {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }


    @GetMapping
    public ResponseEntity<Collection<Animal>> readAll(
            @RequestParam(name = "_page", defaultValue = "1") int page,
            @RequestParam(name = "_size", defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(this.animalService.readAll(pageable).toList());
    }

    @GetMapping(path = {"/{id:[0-9]+}"})
    public ResponseEntity<Animal> readOne(
            @PathVariable Integer id
    ) {
        Animal animal = this.animalService.readOneByKey(id).orElseThrow(() -> new HttpNotFoundException("Animal with id(" + id + ") is not found"));

        return ResponseEntity.ok(animal);
    }
}
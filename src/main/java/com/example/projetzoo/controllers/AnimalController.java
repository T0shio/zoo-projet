package com.example.projetzoo.controllers;


import com.example.projetzoo.exceptions.HttpNotFoundException;
import com.example.projetzoo.models.entities.Animal;
import com.example.projetzoo.models.entities.Area;
import com.example.projetzoo.models.entities.Zoo;
import com.example.projetzoo.models.forms.AnimalCreateForm;
import com.example.projetzoo.repositories.AnimalRepository;
import com.example.projetzoo.repositories.AreaRepository;
import com.example.projetzoo.repositories.ZooRepository;
import com.example.projetzoo.services.animal.AnimalService;
import com.example.projetzoo.services.area.AreaService;
import com.example.projetzoo.services.zoo.ZooService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = {"/animal"})
public class AnimalController implements BaseRestController<Animal, Integer> {
    private final AnimalService animalService;
    private final AreaService areaService;
    private final AreaRepository areaRepository;
    private final AnimalRepository animalRepository;

    public AnimalController(AnimalService animalService, AreaService areaService, AnimalRepository animalRepository, AreaRepository areaRepository) {
        this.animalService = animalService;
        this.areaService = areaService;
        this.areaRepository = areaRepository;
        this.animalRepository = animalRepository;
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
    @PostMapping
    public ResponseEntity<Animal> insert(@RequestBody AnimalCreateForm form) {
        Animal animal = this.animalService.save(form.toBll());
        Area areas = areaService.readOneByKey((int)form.getAreaId()).orElseThrow();
        animal.setAreas(areas);
        return ResponseEntity.ok(animalService.save(animal));
    }
}
package com.example.projetzoo.controllers;

import com.example.projetzoo.exceptions.HttpNotFoundException;
import com.example.projetzoo.models.entities.Area;
import com.example.projetzoo.models.entities.Zoo;
import com.example.projetzoo.models.forms.AreaCreateForm;
import com.example.projetzoo.repositories.AreaRepository;
import com.example.projetzoo.repositories.ZooRepository;
import com.example.projetzoo.services.area.AreaService;
import com.example.projetzoo.services.zoo.ZooService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = {"/area"})
public class AreaController implements BaseRestController<Area, Integer> {
    private final AreaService areaService;
    private final ZooService zooService;

    public AreaController(AreaService areaService, ZooService zooService,
                          AreaRepository areaRepository,
                          ZooRepository zooRepository) {
        this.areaService = areaService;
        this.zooService = zooService;
    }


    @GetMapping
    public ResponseEntity<Collection<Area>> readAll(
            @RequestParam(name = "_page", defaultValue = "1") int page,
            @RequestParam(name = "_size", defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(this.areaService.readAll(pageable).toList());
    }

    @GetMapping(path = {"/{id:[0-9]+}"})
    public ResponseEntity<Area> readOne(
            @PathVariable Integer id
    ) {
        Area area = this.areaService.readOneByKey(id).orElseThrow(() -> new HttpNotFoundException("Area with id(" + id + ") is not found"));

        return ResponseEntity.ok(area);
    }

    @PostMapping
    public ResponseEntity<Area> insert(@RequestBody AreaCreateForm form) {
        Area area = form.toBll();
        Zoo zoo = zooService.readOneByKey((int)form.getZooId()).orElseThrow();
        area.setZoo(zoo);
        return ResponseEntity.ok(areaService.save(area));
    }
}
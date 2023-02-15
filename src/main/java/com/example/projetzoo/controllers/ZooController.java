package com.example.projetzoo.controllers;

import com.example.projetzoo.exceptions.HttpNotFoundException;
import com.example.projetzoo.models.entities.Animal;
import com.example.projetzoo.models.entities.Area;
import com.example.projetzoo.models.entities.Zoo;
import com.example.projetzoo.models.forms.ZooCreateForm;
import com.example.projetzoo.repositories.AreaRepository;
import com.example.projetzoo.services.area.AreaService;
import com.example.projetzoo.services.zoo.ZooService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = {"/zoo"})
public class ZooController implements BaseRestController<Zoo, Integer> {
    private final ZooService zooService;
    private final AreaService areaService;
    private final AreaRepository areaRepository;

    public ZooController(ZooService zooService, AreaService areaService,
                         AreaRepository areaRepository) {
        this.zooService = zooService;
        this.areaService = areaService;
        this.areaRepository = areaRepository;
    }


    @GetMapping
    public ResponseEntity<Collection<Zoo>> readAll(
            @RequestParam(name = "_page", defaultValue = "1") int page,
            @RequestParam(name = "_size", defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(this.zooService.readAll(pageable).toList());
    }

    @GetMapping(path = {"/{id:[0-9]+}"})
    public ResponseEntity<Zoo> readOne(
            @PathVariable Integer id
    ) {
        Zoo zoo = this.zooService
                .readOneByKey(id)
                .orElseThrow(() -> new HttpNotFoundException("Zoo with id(" + id + ") is not found"));

        return ResponseEntity.ok(zoo);
    }

    @GetMapping(path = {"/zoo/{id}/area"})
    public ResponseEntity<Area> getAreas() {
        return ResponseEntity.ok(new Area());
    }

    @PostMapping
    public ResponseEntity<Zoo> insert(@RequestBody ZooCreateForm form) {
        Zoo zoo = this.zooService.save(form.toBll());
        Area areas = areaService.readOneByKey((int) form.getAreaId()).orElseThrow();
        zoo.setAreas(areas);
        return ResponseEntity.ok(zoo);
    }
}
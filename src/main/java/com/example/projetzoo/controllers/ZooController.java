package com.example.projetzoo.controllers;

import com.example.projetzoo.exceptions.HttpNotFoundException;
import com.example.projetzoo.models.entities.Employee;
import com.example.projetzoo.models.entities.Zoo;
import com.example.projetzoo.models.forms.EmployeeCreateForm;
import com.example.projetzoo.models.forms.ZooCreateForm;
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

    public ZooController(ZooService zooService) {
        this.zooService = zooService;
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
        Zoo zoo = this.zooService.readOneByKey(id).orElseThrow(() -> new HttpNotFoundException("Zoo with id(" + id + ") is not found"));

        return ResponseEntity.ok(zoo);
    }
    @PostMapping
    public ResponseEntity<Zoo> insert(@RequestBody ZooCreateForm form) {
        Zoo zoo = this.zooService.save(form.toBll());
        return ResponseEntity.ok(zoo);
    }
}
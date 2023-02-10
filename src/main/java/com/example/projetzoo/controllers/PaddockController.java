package com.example.projetzoo.controllers;

import com.example.projetzoo.exceptions.HttpNotFoundException;
import com.example.projetzoo.models.entities.Paddock;
import com.example.projetzoo.models.forms.PaddockCreateForm;
import com.example.projetzoo.services.paddock.PaddockService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path ={"/Paddock"})
public class PaddockController implements BaseRestController<Paddock, Integer>{
    private final PaddockService paddockService;

    public PaddockController(PaddockService paddockService) {
        this.paddockService = paddockService;
    }


    @GetMapping
    public ResponseEntity<Collection<Paddock>> readAll(
            @RequestParam(name = "_page", defaultValue = "1") int page,
            @RequestParam(name = "_size", defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(this.paddockService.readAll(pageable).toList());
    }

    @GetMapping(path = {"/{id:[0-9]+}"})
    public ResponseEntity<Paddock> readOne(
            @PathVariable Integer id
    ) {
        Paddock paddock = this.paddockService.readOneByKey(id).orElseThrow(() -> new HttpNotFoundException("Employee with id(" + id + ") is not found"));

        return ResponseEntity.ok(paddock);

    }
    @PostMapping
    public ResponseEntity<Paddock> insert(@RequestBody PaddockCreateForm form) {
        Paddock paddock = this.paddockService.save(form.toBll());
        return ResponseEntity.ok(paddock);
    }
}

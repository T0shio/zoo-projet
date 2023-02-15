package com.example.projetzoo.controllers;
import com.example.projetzoo.exceptions.HttpNotFoundException;
import com.example.projetzoo.models.entities.Employee;
import com.example.projetzoo.models.entities.Provider;
import com.example.projetzoo.models.forms.EmployeeCreateForm;
import com.example.projetzoo.models.forms.ProviderCreateForm;
import com.example.projetzoo.repositories.ProviderRepository;
import com.example.projetzoo.services.provider.ProviderService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = {"/provider"})
public class ProviderController implements BaseRestController<Provider, Integer> {
    private final ProviderService providerService;
    private final ProviderRepository providerRepository;

    public ProviderController(ProviderService providerService,
                              ProviderRepository providerRepository) {
        this.providerService = providerService;
        this.providerRepository = providerRepository;
    }


    @GetMapping
    public ResponseEntity<Collection<Provider>> readAll(
            @RequestParam(name = "_page", defaultValue = "1") int page,
            @RequestParam(name = "_size", defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(this.providerService.readAll(pageable).toList());
    }

    @GetMapping(path = {"/{id:[0-9]+}"})
    public ResponseEntity<Provider> readOne(
            @PathVariable Integer id
    ) {
        Provider provider = this.providerService.readOneByKey(id).orElseThrow(() -> new HttpNotFoundException("Provider with id(" + id + ") is not found"));

        return ResponseEntity.ok(provider);
    }
    @PostMapping
    public ResponseEntity<Provider> insert(@RequestBody ProviderCreateForm form) {
        Provider provider = this.providerService.save(form.toBll());
        return ResponseEntity.ok(provider);
    }
    @PatchMapping
    public ResponseEntity<Provider> update(@RequestBody ProviderCreateForm form){
        Provider provider = this.providerService.save(form.toBll());
        return ResponseEntity.ok(provider);
    }
}
package com.example.projetzoo.controllers;
import com.example.projetzoo.exceptions.HttpNotFoundException;
import com.example.projetzoo.models.entities.Employee;
import com.example.projetzoo.services.employee.EmployeeService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = {"/employee"})
public class EmployeeController implements BaseRestController<Employee, Integer> {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public ResponseEntity<Collection<Employee>> readAll(
            @RequestParam(name = "_page", defaultValue = "1") int page,
            @RequestParam(name = "_size", defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(this.employeeService.readAll(pageable).toList());
    }

    @GetMapping(path = {"/{id:[0-9]+}"})
    public ResponseEntity<Employee> readOne(
            @PathVariable Integer id
    ) {
        Employee employee = this.employeeService.readOneByKey(id).orElseThrow(() -> new HttpNotFoundException("Employee with id(" + id + ") is not found"));

        return ResponseEntity.ok(employee);
    }
}
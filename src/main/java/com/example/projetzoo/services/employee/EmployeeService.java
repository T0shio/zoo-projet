package com.example.projetzoo.services.employee;

import com.example.projetzoo.models.entities.Employee;
import com.example.projetzoo.services.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService extends CrudService<Employee, Integer> {
}

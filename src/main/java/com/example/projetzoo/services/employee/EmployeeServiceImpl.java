package com.example.projetzoo.services.employee;

import com.example.projetzoo.models.entities.Employee;
import com.example.projetzoo.repositories.EmployeeRepository;
import com.example.projetzoo.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends CrudServiceImpl<EmployeeRepository, Employee, Integer> implements EmployeeService {

    public EmployeeServiceImpl(
            EmployeeRepository employeeRepository
    ) {
        super(employeeRepository);
    }
}

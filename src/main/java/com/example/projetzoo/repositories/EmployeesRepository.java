package com.example.projetzoo.repositories;

import com.example.projetzoo.models.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository <Employee, String> {
    List<Employee> findAllByActive(boolean active);
}

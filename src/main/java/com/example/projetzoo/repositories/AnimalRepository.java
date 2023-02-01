package com.example.projetzoo.repositories;

import com.example.projetzoo.models.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository <Animal, Integer> {
    List<Animal> findAllByActive(boolean active);
}

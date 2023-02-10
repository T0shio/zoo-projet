package com.example.projetzoo.repositories;

import com.example.projetzoo.models.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface AnimalRepository extends JpaRepository <Animal, Integer> {

    @Query(value = "SELECT a FROM Animal a ORDER BY a.species ASC, a.sex ASC")
    Stream<Animal> readAll();
    List<Animal> findAllByActive(boolean active);
}

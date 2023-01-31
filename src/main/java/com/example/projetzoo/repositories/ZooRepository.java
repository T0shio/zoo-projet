package com.example.projetzoo.repositories;

import com.example.projetzoo.models.entities.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZooRepository extends JpaRepository<Zoo, String> {
    List<Zoo> findAllByActive (boolean active);
}

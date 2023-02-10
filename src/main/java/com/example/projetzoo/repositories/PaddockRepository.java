package com.example.projetzoo.repositories;

import com.example.projetzoo.models.entities.Paddock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaddockRepository extends JpaRepository<Paddock, Integer> {
    List<Paddock> findAllByActive(boolean active);
}

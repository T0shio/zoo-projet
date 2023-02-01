package com.example.projetzoo.repositories;

import com.example.projetzoo.models.entities.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository <Area, Integer> {
    List<Area> findAllByActive(boolean active);
}

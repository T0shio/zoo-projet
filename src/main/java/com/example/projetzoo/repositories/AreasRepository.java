package com.example.projetzoo.repositories;

import com.example.projetzoo.models.entities.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreasRepository extends JpaRepository <Area, String> {
    List<Area> findAllByActive(boolean active);
}

package com.example.projetzoo.repositories;

import com.example.projetzoo.models.entities.Animal;
import com.example.projetzoo.models.entities.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface AreaRepository extends JpaRepository <Area, Integer> {
    @Query(value = "SELECT a FROM Area a ORDER BY a.paddock.active")
    Stream<Area> readAll();
    List<Area> findAllByActive(boolean active);
}
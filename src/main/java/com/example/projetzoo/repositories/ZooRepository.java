package com.example.projetzoo.repositories;

import com.example.projetzoo.models.entities.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZooRepository extends JpaRepository<Zoo, Integer> {
    List<Zoo> findAllByActive (boolean active);
}

package com.example.projetzoo.repositories;

import com.example.projetzoo.models.entities.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepository extends JpaRepository <Provider, Integer> {
    List<Provider> findAllByActive(boolean active);
}

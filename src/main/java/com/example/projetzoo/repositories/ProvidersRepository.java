package com.example.projetzoo.repositories;

import com.example.projetzoo.models.entities.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvidersRepository extends JpaRepository <Provider, String> {
    List<Provider> findAllByActive(boolean active);
}

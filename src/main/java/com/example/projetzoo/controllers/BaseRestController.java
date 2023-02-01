package com.example.projetzoo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

public interface BaseRestController<TEntity, TKey> {
    ResponseEntity<TEntity> readOne(TKey id);

    ResponseEntity<Collection<TEntity>> readAll(
            @RequestParam(name = "_page", defaultValue = "1") int page,
            @RequestParam(name = "_size", defaultValue = "5") int size
    );
}

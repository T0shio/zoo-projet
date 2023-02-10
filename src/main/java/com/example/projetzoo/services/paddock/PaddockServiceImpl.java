package com.example.projetzoo.services.paddock;


import com.example.projetzoo.models.entities.Paddock;

import com.example.projetzoo.repositories.PaddockRepository;
import com.example.projetzoo.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PaddockServiceImpl extends CrudServiceImpl<PaddockRepository, Paddock, Integer> implements PaddockService {
    protected PaddockServiceImpl(PaddockRepository paddockRepository) {
        super(paddockRepository);
    }
}
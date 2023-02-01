package com.example.projetzoo.services.zoo;

import com.example.projetzoo.models.entities.Zoo;
import com.example.projetzoo.repositories.ZooRepository;
import com.example.projetzoo.services.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZooServiceImpl extends CrudServiceImpl<ZooRepository, Zoo, Integer> implements ZooService  {

    public ZooServiceImpl(
            ZooRepository ZooRepository
    ) {
        super(ZooRepository);
    }
}

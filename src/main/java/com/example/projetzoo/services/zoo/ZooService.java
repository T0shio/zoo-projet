package com.example.projetzoo.services.zoo;

import com.example.projetzoo.models.entities.Zoo;
import com.example.projetzoo.services.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface ZooService extends CrudService<Zoo, Integer> {
}

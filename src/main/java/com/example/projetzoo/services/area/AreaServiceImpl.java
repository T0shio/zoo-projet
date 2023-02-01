package com.example.projetzoo.services.area;

import com.example.projetzoo.models.entities.Area;
import com.example.projetzoo.repositories.AreaRepository;
import com.example.projetzoo.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl extends CrudServiceImpl<AreaRepository, Area, Integer> implements AreaService{
    public AreaServiceImpl(AreaRepository areaRepository) {
        super(areaRepository);
    }
}

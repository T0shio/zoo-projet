package com.example.projetzoo.services.provider;

import com.example.projetzoo.models.entities.Provider;
import com.example.projetzoo.services.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface ProviderService extends CrudService<Provider, Integer> {
}

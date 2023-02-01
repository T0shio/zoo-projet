package com.example.projetzoo.services.provider;

import com.example.projetzoo.models.entities.Provider;
import com.example.projetzoo.repositories.ProviderRepository;
import com.example.projetzoo.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl extends CrudServiceImpl<ProviderRepository, Provider, Integer> implements ProviderService{
    public ProviderServiceImpl(
            ProviderRepository providerRepository
    ) {
        super(providerRepository);
    }
}
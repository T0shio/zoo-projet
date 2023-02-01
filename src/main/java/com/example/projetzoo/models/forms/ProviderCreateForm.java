package com.example.projetzoo.models.forms;

import com.example.projetzoo.models.entities.Area;
import com.example.projetzoo.models.entities.Provider;

import java.util.ArrayList;

public class ProviderCreateForm {
    private String nameProviders;
    private String productProvided;
    public Provider toBll() {
        Provider entity = new Provider();
        entity.setNameProviders(nameProviders);
        entity.setProductsProvided(productProvided);
        return entity;
    }
}

package com.example.projetzoo.models.dtos.providers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProviderDto {
    private Integer id;
    private String providersName;

}

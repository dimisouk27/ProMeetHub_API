package com.promeethub_api.api.models.dtos;

import com.promeethub_api.domain.entities.ServiceProviderEntity;

public record ServiceProviderDTO(
        String lastName,
        String firstName
) {

    public static ServiceProviderDTO fromEntity(ServiceProviderEntity serviceProvider){
        return new ServiceProviderDTO(
                serviceProvider.getLastName(),
                serviceProvider.getFirstName()
        );
    }
}

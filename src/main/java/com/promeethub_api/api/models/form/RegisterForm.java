package com.promeethub_api.api.models.form;

import com.promeethub_api.api.validation.contraint.Email;
import com.promeethub_api.api.validation.contraint.Password;
import com.promeethub_api.api.validation.contraint.Tel;
import com.promeethub_api.domain.entities.*;
import com.promeethub_api.domain.enums.UserRole;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterForm(
        @NotNull UserRole role,
        @NotBlank String lastName,
        @NotBlank String firstName,
        @NotBlank @Email String email,
        @Password String password,
        @NotBlank @Tel String phoneNumber,
        @Valid @NotNull AddressForm addressForm //not null parce que c'est un record, pour les string on peut mettre @NotBlank
) {
    public UserEntity toEntity() {
        return  switch (role){
            case ADMIN -> null;
            case SERVICE_PROVIDER ->
                new ServiceProviderEntity(lastName, firstName, email, password, phoneNumber, addressForm.ToEmbeddable());

            case CLIENT ->
                new ClientEntity(lastName, firstName, email, password, phoneNumber, addressForm.ToEmbeddable());
        };
    }

    public record AddressForm(
            @Min(1) int streetNumber,
            @NotBlank String street,
            @Min(1) int zipCode,
            @NotBlank String city,
            @NotBlank String country
    ){
        public Address ToEmbeddable(){
            return new Address( street,streetNumber,city, zipCode, country);
        }

    }
}

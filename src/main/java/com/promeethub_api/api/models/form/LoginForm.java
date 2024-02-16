package com.promeethub_api.api.models.form;

import com.promeethub_api.api.validation.contraint.Email;
import com.promeethub_api.api.validation.contraint.Password;
import com.promeethub_api.domain.entities.UserEntity;
import jakarta.validation.constraints.NotBlank;

public record LoginForm(
        @NotBlank @Email String email,
        @Password String password
        )
{
    public UserEntity toEntity() {
        return new UserEntity(email,password);
    }
}

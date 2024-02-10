package com.promeethub_api.businessLayer.services;

import com.promeethub_api.api.models.dtos.AuthDTO;
import com.promeethub_api.domain.entities.UserEntity;

public interface AuthService {
    AuthDTO login(String username, String password);
    AuthDTO register(UserEntity user);
}

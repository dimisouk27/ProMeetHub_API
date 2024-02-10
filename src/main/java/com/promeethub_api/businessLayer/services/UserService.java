package com.promeethub_api.businessLayer.services;

import com.promeethub_api.domain.entities.UserEntity;

public interface UserService extends BaseService<UserEntity, Long> {
    UserEntity findByEmail(String email);


}

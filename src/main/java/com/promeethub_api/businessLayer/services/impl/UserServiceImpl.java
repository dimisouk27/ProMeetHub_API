package com.promeethub_api.businessLayer.services.impl;

import com.promeethub_api.api.configs.security.JWTProvider;
import com.promeethub_api.domain.entities.UserEntity;
import com.promeethub_api.dal.repositories.UserRepository;
import com.promeethub_api.businessLayer.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JWTProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getOne(Long aLong) {
        return userRepository.findById(aLong).orElse(null);
    }

    @Override
    public UserEntity create(UserEntity userEntity) {
        userEntity.setId(null);
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity delete(Long aLong) {
        UserEntity toDelete = getOne(aLong);
        userRepository.delete(toDelete);
        return toDelete;
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}

package com.promeethub_api.businessLayer.services.impl;

import com.promeethub_api.api.configs.security.JWTProvider;
import com.promeethub_api.api.models.dtos.AuthDTO;
import com.promeethub_api.businessLayer.exceptions.EntityAlreadyExistsException;
import com.promeethub_api.dal.repositories.UserRepository;
import com.promeethub_api.domain.entities.UserEntity;
import com.promeethub_api.businessLayer.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JWTProvider jwtProvider;
    @Override
    public AuthDTO login(String username, String password) {
        return null;
    }

    @Override
    public AuthDTO register(UserEntity user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent())
            throw new EntityAlreadyExistsException("email", user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity userCreated = userRepository.save(user);

        return AuthDTO.builder()
                .login(userCreated.getEmail())
                .token(jwtProvider.generateToken(userCreated.getEmail(), userCreated.getRole()))
                .role(userCreated.getRole())
                .build();
    }
}

package com.promeethub_api.businessLayer.services.impl;

import com.promeethub_api.api.configs.security.JWTProvider;
import com.promeethub_api.api.models.dtos.AuthDTO;
import com.promeethub_api.businessLayer.exceptions.EntityAlreadyExistsException;
import com.promeethub_api.businessLayer.exceptions.EntityNotFoundException;
import com.promeethub_api.dal.repositories.UserRepository;
import com.promeethub_api.domain.entities.UserEntity;
import com.promeethub_api.businessLayer.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTProvider jwtProvider;
    @Override
    public AuthDTO login(UserEntity userTolog) {
        UserEntity user = userRepository.findByEmail((userTolog.getEmail())).orElse(null);
        if( user == null )
            throw new EntityNotFoundException(userTolog.getEmail(), UserEntity.class);

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userTolog.getEmail(), userTolog.getPassword())
            );
        }catch (AuthenticationException e){
            throw new BadCredentialsException("Invalid email or password");
        }

        return AuthDTO.builder()
                .login(user.getEmail())
                .token(jwtProvider.generateToken(user.getEmail(), user.getRole()))
                .role(user.getRole())
                .build();
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

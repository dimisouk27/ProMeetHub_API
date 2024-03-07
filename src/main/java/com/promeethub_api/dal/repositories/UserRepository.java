package com.promeethub_api.dal.repositories;

import com.promeethub_api.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

    Optional<UserEntity> findByEmail(String email);
    boolean existsByLastNameAndFirstName(String last_name, String first_name);

}

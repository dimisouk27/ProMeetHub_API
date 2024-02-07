package com.promeethub_api.domain.entities;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter @Getter
@Entity
@Table(name = "\"client\"")
public class ClientEntity extends UserEntity {
    @OneToMany(mappedBy = "client")
    private List<ServiceEntity> services;
}
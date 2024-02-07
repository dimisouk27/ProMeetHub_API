package com.promeethub_api.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@Entity
@Table(name = "\"service_provider\"")
public class ServiceProviderEntity extends UserEntity {

    @ManyToMany
    @JoinTable(
            name = "service_provider_offers",
            joinColumns = @JoinColumn(name = "service_provider_id"),
            inverseJoinColumns = @JoinColumn(name = "service_category_id"))
    private List<ServiceCategoryEntity> categories;
    @OneToMany(mappedBy = "serviceProvider")
    private List<ServiceEntity> services;


}
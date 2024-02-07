package com.promeethub_api.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter  @Getter
@Entity
@Table(name = "service_category")
@NoArgsConstructor
public class ServiceCategoryEntity {
    @Id
    private Long id;
    private String name;
    @ManyToOne
    private ServiceCategoryEntity parent;
    @OneToMany(mappedBy = "parent")
    private List<ServiceCategoryEntity> children;
    @ManyToMany(mappedBy = "categories")
    private List<ServiceProviderEntity> serviceProviders;

    public ServiceCategoryEntity(String name) {
        this.name = name;
    }
    public ServiceCategoryEntity(String name, ServiceCategoryEntity parent) {
        this.name = name;
        this.parent = parent;
    }


}
package com.promeethub_api.domain.entities;

import com.promeethub_api.domain.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@Entity
@Table(name = "\"service_provider\"")
@NoArgsConstructor
public class ServiceProviderEntity extends UserEntity {

    @ManyToMany
    @JoinTable(
            name = "service_provider_offers",
            joinColumns = @JoinColumn(name = "service_provider_id"),
            inverseJoinColumns = @JoinColumn(name = "service_category_id"))
    private List<ServiceCategoryEntity> categories;
    @OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServiceTypeEntity> servicesTypes;


    public ServiceProviderEntity(String lastName, String firstName, String email, String password, String phoneNumber,Address address) {
        super(null,lastName, firstName, email, password, phoneNumber, address, UserRole.SERVICE_PROVIDER );
    }
}
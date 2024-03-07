package com.promeethub_api.domain.entities;

import com.promeethub_api.domain.enums.UserRole;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter @Getter
@Entity
@Table(name = "\"client\"")
@NoArgsConstructor
public class ClientEntity extends UserEntity {
//    @OneToMany(mappedBy = "client")
//    private List<ServiceTypeEntity> services; ça sera le booking

    public ClientEntity(String lastName, String firstName, String email, String password, String phoneNumber,Address address) {
        super(null,lastName, firstName, email, password, phoneNumber, address, UserRole.CLIENT );
    }
}
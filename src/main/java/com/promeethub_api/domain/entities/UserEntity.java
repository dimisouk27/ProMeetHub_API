package com.promeethub_api.domain.entities;


import com.promeethub_api.domain.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@Entity
@Table(name = "\"user\"")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UserEntity {

    @Id
    protected Long id;
    @Column(name = "last_name", length = 50, nullable = false)
    protected String lastName;
    @Column(name = "first_name", length = 50, nullable = false)
    protected String firstName;
    @Column(name = "email", length = 50, nullable = false)
    protected String email;
    @Column(name = "password", length = 50, nullable = false)
    protected String password;
    @Column(name = "phone", length = 12, nullable = false)
    protected String phone;
    @Embedded
    protected Address address;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    protected UserRole role;




}
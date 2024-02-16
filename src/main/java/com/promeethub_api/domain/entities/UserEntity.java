package com.promeethub_api.domain.entities;


import com.promeethub_api.domain.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Setter @Getter
@Entity
@Table(name = "\"user\"")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "last_name", length = 50, nullable = false)
    protected String lastName;
    @Column(name = "first_name", length = 50, nullable = false)
    protected String firstName;
    @Column(name = "email", length = 50, nullable = false)
    protected String email;
    @Column(name = "password", nullable = false)
    protected String password;
    @Column(name = "phone", length = 12)
    protected String phone;
    @Embedded
    protected Address address;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    protected UserRole role;
    //protected boolean enabled;// pour la suppression de compte

    public UserEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.toString()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }




}
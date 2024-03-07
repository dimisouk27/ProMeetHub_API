package com.promeethub_api.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String street;
    @Column(name = "street_number")
    private int streetNumber;
    private String city;
    @Column(name = "zip_code")
    private int zipCode;
    private String country;

}

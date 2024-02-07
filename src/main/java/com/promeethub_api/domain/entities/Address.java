package com.promeethub_api.domain.entities;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class Address {
    private String street;
    private int number;
    private String city;
    private String country;
    private int zipCode;
}

package com.promeethub_api.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter @Getter
@Entity
@Table(name = "\"service\"")
@NoArgsConstructor
@AllArgsConstructor
public class ServiceEntity {
    @Id
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private String location;
    private String status;
    //private int evaluation;
    @ManyToOne
    private ServiceCategoryEntity category;
    @ManyToOne
    private ClientEntity client;
    @ManyToOne
    private ServiceProviderEntity serviceProvider;

}
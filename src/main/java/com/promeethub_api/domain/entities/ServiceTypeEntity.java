package com.promeethub_api.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Setter @Getter
@Entity
@Table(
        name = "\"service_type\"",
        uniqueConstraints = @UniqueConstraint(
                name = "UK_TITLE_SP_ID",
                columnNames = {
                    "title", "service_provider_id"
                }
        )
)
@NoArgsConstructor
@AllArgsConstructor
public class ServiceTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(length = 1000)
    private String description;
    @Column(nullable = false)
    private LocalDate startDate;
    @Column(nullable = false)
    private LocalDate endDate;
    @Column(nullable = false)
    private LocalTime startTime;
    @Column(nullable = false)
    private LocalTime endTime;
    @OneToMany(mappedBy = "serviceType", cascade = CascadeType.ALL)
    private List<DayEntity> availabilities;
    private String url;
    @Column(nullable = false)
    private long duration;
    private boolean enabled;
    //private int evaluation;
    @ManyToOne
    private ServiceCategoryEntity category;
    @ManyToOne
    private ServiceProviderEntity serviceProvider;

    public ServiceTypeEntity
    (
        String title,
        String description,
        LocalDate startDate,
        LocalDate endDate,
        LocalTime startTime,
        LocalTime endTime,
        long duration,
        boolean enabled,
        ServiceCategoryEntity category,
        ServiceProviderEntity serviceProvider
    ) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.enabled = enabled;
        this.category = category;
        this.serviceProvider = serviceProvider;
    }

    private void initAvailabilities(){
        availabilities = new ArrayList<>();
        LocalDate dateToAdd = startDate;
        while(dateToAdd.isBefore(endDate) || dateToAdd.isEqual(endDate) ){
            availabilities.add(new DayEntity(dateToAdd, this.startTime, this.endTime,duration,this));
            dateToAdd = dateToAdd.plusDays(1);
        }


    }

    public void setUrl() {

        this.url = "http://localhost:4200/service-provider/"+serviceProvider.getLastName()+
                "_"+serviceProvider.getFirstName()+"/"+title;
        initAvailabilities();
    }
}
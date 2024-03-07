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

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "\"day\"")
public class DayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL)
    private List<TimeSlotEntity> timeSlots;
    @ManyToOne
    private ServiceTypeEntity serviceType;

    public DayEntity(LocalDate date, LocalTime startTime, LocalTime endTime, long duration, ServiceTypeEntity serviceType) {
        this.date = date;
        this.serviceType = serviceType;
        initTimeSlots(startTime,endTime,duration);
    }

    private void initTimeSlots(LocalTime startTime, LocalTime endTime, long duration){
        LocalTime newTime = startTime;
        timeSlots = new ArrayList<>();

        while(newTime.isBefore(endTime) || newTime == endTime){
            timeSlots.add(new TimeSlotEntity(null, newTime, this));
            newTime = newTime.plusMinutes(duration);
        }
        //timeSlots.add(new TimeSlotEntity(null, endTime, this));// because the endTime is not added
    }
}
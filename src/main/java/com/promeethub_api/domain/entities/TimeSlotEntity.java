package com.promeethub_api.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter
@Getter
@Entity
@Table(name = "\"time_slot\"")
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime time;
    @ManyToOne
    private DayEntity day;
    private boolean isTaken;

    public TimeSlotEntity(Long id, LocalTime time, DayEntity day) {
        this.id = id;
        this.time = time;
        this.day = day;
    }
}
package com.promeethub_api.api.models.dtos;

import com.promeethub_api.domain.entities.ServiceCategoryEntity;
import com.promeethub_api.domain.entities.ServiceProviderEntity;
import com.promeethub_api.domain.entities.ServiceTypeEntity;

import java.time.LocalDate;
import java.time.LocalTime;

public record ServiceTypeDTO(
        String title,
        String description,
        LocalDate startDate,
        LocalDate endDate,
        LocalTime startTime,
        LocalTime endTime,
        long duration,
        boolean enabled,
        String categoryName,
        String url
) {
    public static ServiceTypeDTO  fromEntity (ServiceTypeEntity serviceTypeEntity){
        return new ServiceTypeDTO(serviceTypeEntity.getTitle(),
                serviceTypeEntity.getDescription(),
                serviceTypeEntity.getStartDate(),
                serviceTypeEntity.getEndDate(),
                serviceTypeEntity.getStartTime(),
                serviceTypeEntity.getEndTime(),
                serviceTypeEntity.getDuration(),
                serviceTypeEntity.isEnabled(),
                serviceTypeEntity.getCategory().getName(),
                serviceTypeEntity.getUrl());
    }
}

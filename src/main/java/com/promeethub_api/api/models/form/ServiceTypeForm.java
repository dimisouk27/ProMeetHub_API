package com.promeethub_api.api.models.form;

import com.promeethub_api.api.validation.contraint.GreaterThan;
import com.promeethub_api.api.validation.contraint.GreaterThans;
import com.promeethub_api.domain.entities.ServiceCategoryEntity;
import com.promeethub_api.domain.entities.ServiceProviderEntity;
import com.promeethub_api.domain.entities.ServiceTypeEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
@GreaterThans(
        {
                @GreaterThan(min="startDate", max = "endDate"),
                @GreaterThan(min= "startTime", max="endTime")
        }

)
public record ServiceTypeForm(
        @NotBlank String title,
        @NotBlank String description,
        @NotNull LocalDate startDate,
        @NotNull LocalDate endDate,
        @NotNull LocalTime startTime,
        @NotNull LocalTime endTime,
        @Min(5) long duration,
        @NotBlank String categoryName,
        @NotBlank String login

) {
    public ServiceTypeEntity toEntity(){
        ServiceCategoryEntity serviceCategoryEntity= new ServiceCategoryEntity(Character.toTitleCase(categoryName.charAt(0)) + categoryName.substring(1));
        ServiceProviderEntity serviceProvider = new ServiceProviderEntity();
        serviceProvider.setEmail(login);
        return new ServiceTypeEntity(
                this.title,
                this.description,
                this.startDate,
                this.endDate,
                this.startTime,
                this.endTime,
                this.duration,
                true,
                serviceCategoryEntity,
                serviceProvider

        );
    }
}

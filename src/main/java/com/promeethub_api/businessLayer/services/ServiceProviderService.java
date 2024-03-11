package com.promeethub_api.businessLayer.services;

import com.promeethub_api.api.models.form.ServiceTypeForm;
import com.promeethub_api.domain.entities.ServiceProviderEntity;
import com.promeethub_api.domain.entities.ServiceTypeEntity;

import java.util.List;

public interface ServiceProviderService extends BaseService<ServiceProviderEntity, Long> {
    boolean addServiceType(ServiceTypeForm serviceTypeForm);
    List<ServiceTypeEntity> getMyServiceTypes(String email);

    ServiceProviderEntity getByEmail(String email);
}
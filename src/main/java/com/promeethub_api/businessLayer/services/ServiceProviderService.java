package com.promeethub_api.businessLayer.services;

import com.promeethub_api.api.models.form.ServiceTypeForm;
import com.promeethub_api.domain.entities.ServiceProviderEntity;
import com.promeethub_api.domain.entities.ServiceTypeEntity;

public interface ServiceProviderService extends BaseService<ServiceProviderEntity, Long> {
    boolean addServiceType(ServiceTypeForm serviceTypeForm);
}
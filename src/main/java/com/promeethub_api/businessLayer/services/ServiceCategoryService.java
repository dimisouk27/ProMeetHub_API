package com.promeethub_api.businessLayer.services;

import com.promeethub_api.domain.entities.ServiceCategoryEntity;

public interface ServiceCategoryService extends BaseService<ServiceCategoryEntity, Long> {

    boolean existByName(String categoryName);
    ServiceCategoryEntity getByName(String categoryName);
}
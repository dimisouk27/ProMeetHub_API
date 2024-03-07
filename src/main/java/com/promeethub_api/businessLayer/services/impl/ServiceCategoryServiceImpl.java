package com.promeethub_api.businessLayer.services.impl;

import com.promeethub_api.dal.repositories.ServiceCategoryRepository;
import com.promeethub_api.domain.entities.ServiceCategoryEntity;
import com.promeethub_api.businessLayer.services.ServiceCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ServiceCategoryServiceImpl implements ServiceCategoryService {

    private final ServiceCategoryRepository serviceCategoryRepository;

    @Override
    public List<ServiceCategoryEntity> getAll() {
        return serviceCategoryRepository.findAll();
    }

    @Override
    public ServiceCategoryEntity getOne(Long aLong) {
        return null;
    }

    @Override
    public ServiceCategoryEntity create(ServiceCategoryEntity serviceCategoryEntity) {
        return serviceCategoryRepository.save(serviceCategoryEntity);
    }

    @Override
    public ServiceCategoryEntity update(ServiceCategoryEntity serviceCategoryEntity) {
        return null;
    }

    @Override
    public ServiceCategoryEntity delete(Long aLong) {
        return null;
    }

    @Override
    public boolean existByName(String name) {
        return serviceCategoryRepository.existsByName(name);
    }

    @Override
    public ServiceCategoryEntity getByName(String categoryName) {
        return serviceCategoryRepository.getByName(categoryName);
    }
}

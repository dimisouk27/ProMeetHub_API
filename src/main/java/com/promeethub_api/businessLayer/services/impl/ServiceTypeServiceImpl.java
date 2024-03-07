package com.promeethub_api.businessLayer.services.impl;

import com.promeethub_api.businessLayer.exceptions.EntityAlreadyExistsException;
import com.promeethub_api.dal.repositories.ServiceTypeRepository;
import com.promeethub_api.domain.entities.ServiceTypeEntity;
import com.promeethub_api.businessLayer.services.ServiceTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@RequiredArgsConstructor
@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {

    private final ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceTypeEntity> getAll() {
        return null;
    }

    @Override
    public ServiceTypeEntity getOne(Long aLong) {
        return null;
    }

    @Override
    public ServiceTypeEntity create(ServiceTypeEntity serviceTypeEntity) {
        if(serviceTypeRepository.existsByTitleAndServiceProvider(serviceTypeEntity.getTitle(), serviceTypeEntity.getServiceProvider()))
            throw new EntityAlreadyExistsException("Titre", serviceTypeEntity.getTitle(), "dans vos types de services");

        return serviceTypeRepository.save(serviceTypeEntity);
    }

    @Override
    public ServiceTypeEntity update(ServiceTypeEntity serviceTypeEntity) {
        return null;
    }

    @Override
    public ServiceTypeEntity delete(Long aLong) {
        return null;
    }
}

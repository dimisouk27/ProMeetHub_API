package com.promeethub_api.businessLayer.services.impl;

import com.promeethub_api.domain.entities.ServiceProviderEntity;
import com.promeethub_api.businessLayer.services.ServiceProviderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

    @Override
    public List<ServiceProviderEntity> getAll() {
        return null;
    }

    @Override
    public ServiceProviderEntity getOne(Long aLong) {
        return null;
    }

    @Override
    public ServiceProviderEntity create(ServiceProviderEntity serviceProviderEntity) {
        return null;
    }

    @Override
    public ServiceProviderEntity update(ServiceProviderEntity serviceProviderEntity) {
        return null;
    }

    @Override
    public ServiceProviderEntity delete(Long aLong) {
        return null;
    }
}

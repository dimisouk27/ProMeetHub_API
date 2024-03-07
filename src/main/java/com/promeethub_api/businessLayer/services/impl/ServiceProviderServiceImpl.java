package com.promeethub_api.businessLayer.services.impl;

import com.promeethub_api.api.models.form.ServiceTypeForm;
import com.promeethub_api.businessLayer.exceptions.EntityNotFoundException;
import com.promeethub_api.businessLayer.services.ServiceCategoryService;
import com.promeethub_api.businessLayer.services.ServiceTypeService;
import com.promeethub_api.businessLayer.services.UserService;
import com.promeethub_api.dal.repositories.ServiceProviderRepository;
import com.promeethub_api.domain.entities.ServiceProviderEntity;
import com.promeethub_api.businessLayer.services.ServiceProviderService;
import com.promeethub_api.domain.entities.ServiceTypeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {
    private final ServiceTypeService serviceTypeService;
    private final ServiceProviderRepository serviceProviderRepository;
    private final ServiceCategoryService serviceCategoryService;
    private final UserService userService;
    @Override
    public List<ServiceProviderEntity> getAll() {
        return null;
    }

    @Override
    public ServiceProviderEntity getOne(Long id) {
        return serviceProviderRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id, ServiceTypeEntity.class)
        );
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

    @Override
    public boolean addServiceType(ServiceTypeForm serviceTypeForm) {

        ServiceTypeEntity serviceType = serviceTypeForm.toEntity();
        ServiceProviderEntity createdBy = (ServiceProviderEntity) userService.findByEmail(serviceType.getServiceProvider().getEmail());
        if(createdBy == null)
            throw new EntityNotFoundException(serviceType.getServiceProvider().getEmail(),ServiceProviderEntity.class);
        serviceType.setServiceProvider(createdBy);
        serviceType.setUrl();
        try {
            //Si la categorie n'existe pas on la crée
            if(!serviceCategoryService.existByName(serviceTypeForm.categoryName())){
                serviceCategoryService.create(serviceType.getCategory());
            }
            //Pour que hibernate puisse faire le lien
            serviceType.setCategory(serviceCategoryService.getByName(serviceTypeForm.categoryName()));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return serviceTypeService.create(serviceType) != null;

    }


}

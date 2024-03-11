package com.promeethub_api.dal.repositories;

import com.promeethub_api.domain.entities.ServiceProviderEntity;
import com.promeethub_api.domain.entities.ServiceTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceTypeEntity, Long> {
    boolean existsByTitleAndServiceProvider(String title, ServiceProviderEntity serviceProvider);
    List<ServiceTypeEntity> getAllByServiceProvider(ServiceProviderEntity serviceProvider);
}

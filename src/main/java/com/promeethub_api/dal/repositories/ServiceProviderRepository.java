package com.promeethub_api.dal.repositories;

import com.promeethub_api.domain.entities.ServiceProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProviderEntity, Long>{

}

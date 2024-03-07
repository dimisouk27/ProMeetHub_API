package com.promeethub_api.dal.repositories;

import com.promeethub_api.domain.entities.ServiceCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceCategoryRepository extends JpaRepository<ServiceCategoryEntity, Long> {
    boolean existsByName(String categoryName);
    ServiceCategoryEntity getByName(String categoryName);
}

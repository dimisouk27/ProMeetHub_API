package com.promeethub_api.api.controllers;

import com.promeethub_api.businessLayer.services.ServiceCategoryService;
import com.promeethub_api.domain.entities.ServiceCategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/service_category")
public class ServiceCategoryController {

    private final ServiceCategoryService serviceCategoryService;

    @GetMapping("/")
    ResponseEntity<List<String>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(
                serviceCategoryService.getAll().stream().map(
                        ServiceCategoryEntity::getName
                ).toList()
        );
    }

}

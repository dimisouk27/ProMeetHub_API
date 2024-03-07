package com.promeethub_api.api.controllers;

import com.promeethub_api.api.models.form.ServiceTypeForm;
import com.promeethub_api.businessLayer.services.ServiceProviderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("http://localhost:4200/")
@RequiredArgsConstructor
@RestController
@RequestMapping("/service_provider")
public class ServiceProviderController {

    private final ServiceProviderService serviceProviderService;

    @PostMapping("/add_service_type")
    ResponseEntity<Boolean> addServiceType(@RequestBody @Valid ServiceTypeForm serviceTypeForm){
        boolean isAdded = serviceProviderService.addServiceType(serviceTypeForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(isAdded);
    }
    //TODO: Mettre un bouton partager au lieu de l'URL



}

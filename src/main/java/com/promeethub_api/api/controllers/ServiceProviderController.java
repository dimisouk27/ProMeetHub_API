package com.promeethub_api.api.controllers;

import com.promeethub_api.api.models.dtos.ServiceProviderDTO;
import com.promeethub_api.api.models.dtos.ServiceTypeDTO;
import com.promeethub_api.api.models.form.ServiceTypeForm;
import com.promeethub_api.businessLayer.services.ServiceProviderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200/")
@RequiredArgsConstructor
@RestController
@RequestMapping("/service_provider")
public class ServiceProviderController {

    private final ServiceProviderService serviceProviderService;

    @PostMapping("/add_service_type")
    //@PreAuthorize("hasPermission(Rol)")
    ResponseEntity<Boolean> addServiceType(@RequestBody @Valid ServiceTypeForm serviceTypeForm){
        boolean isAdded = serviceProviderService.addServiceType(serviceTypeForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(isAdded);
    }
    //TODO: Mettre un bouton partager au lieu de l'URL

    @GetMapping("/get_service_types/{email}")
    ResponseEntity<List<ServiceTypeDTO>> getServiceTypes(@PathVariable String email){
        return ResponseEntity.status(HttpStatus.OK).body(
                serviceProviderService.getMyServiceTypes(email).stream().map(ServiceTypeDTO::fromEntity).toList());
    }

    @GetMapping("/{email}")
    ResponseEntity<ServiceProviderDTO> getServiceProvider(@PathVariable String email){
        return ResponseEntity.status(HttpStatus.OK).body(
                ServiceProviderDTO.fromEntity(serviceProviderService.getByEmail(email))

        );
    }

}

package com.apitest.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apitest.demo.dtos.EstablecimientoDto;
import com.apitest.demo.services.EstablishmentService;

@RestController
@RequestMapping("/establishments")
public class EstablishmentController {
    @Autowired
    private EstablishmentService establishmentService;

    @GetMapping
    public List<EstablecimientoDto> getAllEstablishments() {
        return establishmentService.getAllEstablishments();
    }

    @GetMapping("/{id}")
    public EstablecimientoDto getEstablishmentById(@PathVariable String id) {
        return establishmentService.getEstablishment(id);
    }
}   

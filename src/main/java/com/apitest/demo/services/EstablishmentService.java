package com.apitest.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.apitest.demo.dtos.EstablecimientoDto;
import com.apitest.demo.mappers.EstablishmentMapper;
import com.apitest.demo.models.EstablishmentModel;
import com.apitest.demo.repositories.EstablishmentRepository;

@Service
public class EstablishmentService {
    // Inyectamos el repositorio
    private final EstablishmentRepository establishmentRepository;
    private final EstablishmentMapper mapper;

    public EstablishmentService(EstablishmentRepository establishmentRepository, EstablishmentMapper mapper) {
        this.establishmentRepository = establishmentRepository;
        this.mapper = mapper;
    }

    /**
     * Retorna todos los establecimientos
     * @return una lista con todos los establecimientos
     */
    public List<EstablecimientoDto> getAllEstablishments() {
        List<EstablishmentModel> models = establishmentRepository.findAll();
        return models.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene un establecimiento por su ID
     * @param id el ID del establecimiento
     * @return el establecimiento encontrado o null si no se encuentra
     */
    public EstablecimientoDto getEstablishment(String id) {
        EstablishmentModel model = establishmentRepository.findById(id);

        if (model == null) {
            return null;
        }
        return mapper.toDto(model);
    }

}

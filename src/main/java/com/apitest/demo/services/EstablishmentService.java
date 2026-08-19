package com.apitest.demo.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.apitest.demo.dtos.entrada.CrearEstablecimientoRequest;
import com.apitest.demo.dtos.salida.EstablecimientoDto;
import com.apitest.demo.mappers.EstablishmentMapper;
import com.apitest.demo.models.EstablishmentModel;
import com.apitest.demo.repositories.EstablishmentRepository;

import jakarta.validation.Valid;


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

    /**
     * Crea un nuevo establecimiento
     * @param request los datos del establecimiento a crear
     * @return el establecimiento creado
     */
    public EstablecimientoDto createEstablishment(@RequestBody @Valid CrearEstablecimientoRequest request) {
        EstablishmentModel model = mapper.toModel(request);
        model.setId(UUID.randomUUID().toString());
        model.setToken(UUID.randomUUID().toString());
        establishmentRepository.save(model);
        return mapper.toDto(model);
    }

}

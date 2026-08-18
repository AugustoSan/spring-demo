package com.apitest.demo.utils;

import com.apitest.demo.dtos.EstablecimientoDto;
import com.apitest.demo.models.EstablishmentModel;

public class Mapping {

    /**
     * Convierte un modelo de establecimiento en un DTO de establecimiento.
     * @param model
     * @return
     */
    public EstablecimientoDto EstablishMentToDto(EstablishmentModel model) {
        EstablecimientoDto dto = new EstablecimientoDto();
        dto.setId(model.getId());
        dto.setNombre(model.getName());
        dto.setDescripcion(model.getDescription());
        dto.setToken(model.getToken());
        dto.setDireccion(model.getAddress());
        dto.setTelefono(model.getPhone());
        dto.setCorreo(model.getEmail());
        dto.setLogo(model.getLogo());
        return dto;
    }

    /**
     * Convierte un DTO de establecimiento en un modelo de establecimiento.
     * @param dto
     * @return
     */
    public EstablishmentModel toModel(EstablecimientoDto dto) {
        EstablishmentModel model = new EstablishmentModel();
        model.setId(dto.getId());
        model.setName(dto.getNombre());
        model.setDescription(dto.getDescripcion());
        model.setToken(dto.getToken());
        model.setAddress(dto.getDireccion());
        model.setPhone(dto.getTelefono());
        model.setEmail(dto.getCorreo());
        model.setLogo(dto.getLogo());
        return model;
    }
}

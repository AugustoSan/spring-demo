package com.apitest.demo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.apitest.demo.dtos.entrada.CrearEstablecimientoRequest;
import com.apitest.demo.dtos.salida.EstablecimientoDto;
import com.apitest.demo.models.EstablishmentModel;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface EstablishmentMapper {

    // Mapeo de Model -> DTO
    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "description", target = "descripcion")
    @Mapping(source = "address", target = "direccion")
    @Mapping(source = "phone", target = "telefono")
    @Mapping(source = "email", target = "correo")
    @Mapping(source = "logo", target = "logo")
    EstablecimientoDto toDto(EstablishmentModel model);

    // Mapeo de DTO a model
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "token", target = "token")
    @Mapping(source = "direccion", target = "address")
    @Mapping(source = "telefono", target = "phone")
    @Mapping(source = "correo", target = "email")
    @Mapping(source = "logo", target = "logo")
    EstablishmentModel toModel(EstablecimientoDto dto);

    // Mapeo de request a model
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "direccion", target = "address")
    @Mapping(source = "telefono", target = "phone")
    @Mapping(source = "correo", target = "email")
    @Mapping(source = "logo", target = "logo")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "token", ignore = true)
    EstablishmentModel toModel(CrearEstablecimientoRequest request);

}
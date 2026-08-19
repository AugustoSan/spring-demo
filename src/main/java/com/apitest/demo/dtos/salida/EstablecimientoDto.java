package com.apitest.demo.dtos.salida;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstablecimientoDto {
    private String id;
    private String nombre;
    private String descripcion;
    private String token;
    private String direccion;
    private String telefono;
    private String correo;
    private String logo;
}

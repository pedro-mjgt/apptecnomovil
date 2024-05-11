package com.pe.cibertec.apptecnomovil.model.dto.request;

import lombok.Data;

@Data
public class ClienteRequest {
    private Integer clienteid;

    private String nombre;
    private String direccion;
    private String email;
    private String telefono;
    private Boolean activo;
}

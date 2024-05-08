package com.pe.cibertec.apptecnomovil.model.dto.request;

import lombok.Data;

@Data
public class ProductoRequest {

    private Integer productoid;

    private String nombre;
    private Double precio;
    private Integer stock;
    private Boolean activo;

    private Integer categoriaid;
    private Integer marcaid;

}

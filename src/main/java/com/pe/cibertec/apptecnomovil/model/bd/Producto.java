package com.pe.cibertec.apptecnomovil.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productoid;

    private String nombre;
    private Double precio;
    private Integer stock;
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "categoriaid")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "marcaid")
    private Marca marca;

}

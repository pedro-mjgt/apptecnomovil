package com.pe.cibertec.apptecnomovil.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clienteid;
    private String nombre;
    private String direccion;
    private String email;
    private String telefono;
    private Boolean activo;
}

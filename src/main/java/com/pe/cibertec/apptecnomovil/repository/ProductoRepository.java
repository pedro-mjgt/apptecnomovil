package com.pe.cibertec.apptecnomovil.repository;

import com.pe.cibertec.apptecnomovil.model.bd.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {



}

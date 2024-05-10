package com.pe.cibertec.apptecnomovil.repository;

import com.pe.cibertec.apptecnomovil.model.bd.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {



}

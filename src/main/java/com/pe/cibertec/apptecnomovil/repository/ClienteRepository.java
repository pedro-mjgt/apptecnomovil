package com.pe.cibertec.apptecnomovil.repository;

import com.pe.cibertec.apptecnomovil.model.bd.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {



}

package com.example.proyectoIntegrador.persistence.repository;

import com.example.proyectoIntegrador.persistence.entity.Paciente;
import com.example.proyectoIntegrador.persistence.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Integer> {



}

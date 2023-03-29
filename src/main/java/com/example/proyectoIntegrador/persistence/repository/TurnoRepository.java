package com.example.proyectoIntegrador.persistence.repository;

import com.example.proyectoIntegrador.persistence.entity.Paciente;
import com.example.proyectoIntegrador.persistence.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnoRepository extends JpaRepository<Turno,Integer> {

    @Query("SELECT T FROM Turno T WHERE T.odontologo.id = :odontologoId")
    List<Turno> listarTurnoPorOdontologo(@Param("odontologoId") Integer id);

    @Query("SELECT T FROM Turno T WHERE T.paciente.id = :pacienteId")
    List<Turno> listarTurnoPorPaciente(@Param("pacienteId") Integer id);

}
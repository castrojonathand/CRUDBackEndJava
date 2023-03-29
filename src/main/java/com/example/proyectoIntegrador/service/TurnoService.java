package com.example.proyectoIntegrador.service;


import com.example.proyectoIntegrador.persistence.entity.Odontologo;
import com.example.proyectoIntegrador.persistence.entity.Paciente;
import com.example.proyectoIntegrador.persistence.entity.Turno;
import com.example.proyectoIntegrador.persistence.repository.OdontologoRepository;
import com.example.proyectoIntegrador.persistence.repository.PacienteRepository;
import com.example.proyectoIntegrador.persistence.repository.TurnoRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private OdontologoRepository odontologoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public void guardar(@NotNull Turno turno){
        Paciente paciente = pacienteRepository.findById(turno.getPaciente().getId()).orElseThrow();
        Odontologo odontologo = odontologoRepository.findById(turno.getOdontologo().getId()).orElseThrow();

        turno.setPaciente(paciente);
        turno.setOdontologo(odontologo);

        turnoRepository.save(turno);
    }

    public List<Turno> listarTurnoPorOdontologo(Integer id){

        return turnoRepository.listarTurnoPorOdontologo(id);
    }
    public List<Turno> listarTurnoPorPaciente(Integer id){

        return turnoRepository.listarTurnoPorPaciente(id);
    }


    public List<Turno> listar(){
        return turnoRepository.findAll();
    }

    public void eliminarPorId(Integer id){
        turnoRepository.deleteById(id);
    }

}

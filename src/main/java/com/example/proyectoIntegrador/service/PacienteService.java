package com.example.proyectoIntegrador.service;

import com.example.proyectoIntegrador.persistence.entity.Paciente;
import com.example.proyectoIntegrador.persistence.entity.Turno;
import com.example.proyectoIntegrador.persistence.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private TurnoService turnoService;


    public Paciente guardar(Paciente paciente){


        return pacienteRepository.save(paciente);
    }
    public List<Paciente> listar(){
        return pacienteRepository.findAll();
    }

    public void eliminarPorId(Integer id){

        List<Turno> listaTurnos =  turnoService.listarTurnoPorPaciente(id);

        for (int i=0; i<listaTurnos.size(); i++){

            turnoService.eliminarPorId(listaTurnos.get(i).getId());
        }

        pacienteRepository.deleteById(id);
    }

    public void modificar(Paciente paciente) throws NoSuchFieldException {

        Optional<Paciente> optionalPaciente = pacienteRepository.findById(paciente.getId());

        if (optionalPaciente.isPresent()){

            Paciente pacienteExistente = optionalPaciente.get();
            pacienteExistente.setNombre(paciente.getNombre());
            pacienteExistente.setApellido(paciente.getApellido());
            pacienteExistente.setDomicilio(paciente.getDomicilio());
            pacienteExistente.setFechaAlta(paciente.getFechaAlta());

            pacienteRepository.save(pacienteExistente);

        }else {
            throw new NoSuchElementException("Paciente no encontrado");
        }

    }

}

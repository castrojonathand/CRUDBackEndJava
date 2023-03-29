package com.example.proyectoIntegrador.service;

import com.example.proyectoIntegrador.persistence.entity.Odontologo;
import com.example.proyectoIntegrador.persistence.entity.Turno;
import com.example.proyectoIntegrador.persistence.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OdontologoService {

    @Autowired
    private OdontologoRepository odontologoRepository;
    @Autowired
    private TurnoService turnoService;



    public String guardar(Odontologo odontologo){

        if (odontologoRepository.save(odontologo) != null){
            return "Se registro un odontologo";
        }else {
            return null;
        }
    }
    public List<Odontologo> listar(){

        return odontologoRepository.findAll();
    }
    public void eliminarPorId(Integer id) {

        List<Turno> listaTurnos = turnoService.listarTurnoPorOdontologo(id);

        for (int i=0; i< listaTurnos.size();i++){

            turnoService.eliminarPorId(listaTurnos.get(i).getId());

        }
        odontologoRepository.deleteById(id);
    }

    public void modificar(Odontologo odontologo){

        Optional<Odontologo> optionalOdontologo = odontologoRepository.findById(odontologo.getId());
        if (optionalOdontologo.isPresent()) {
            Odontologo odontologoExistente = optionalOdontologo.get();
            odontologoExistente.setNombre(odontologo.getNombre());
            odontologoExistente.setApellido(odontologo.getApellido());
            odontologoExistente.setMatricula(odontologo.getMatricula());
            odontologoRepository.save(odontologoExistente);
        } else {
            throw new NoSuchElementException("Odontólogo no encontrado");
        }



    }





}

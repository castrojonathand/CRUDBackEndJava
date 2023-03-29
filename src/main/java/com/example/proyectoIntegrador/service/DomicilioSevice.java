package com.example.proyectoIntegrador.service;

import com.example.proyectoIntegrador.persistence.entity.Domicilio;
import com.example.proyectoIntegrador.persistence.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DomicilioSevice {

    @Autowired
    private DomicilioRepository domicilioRepository;

    public Domicilio guardar(Domicilio domicilio){

        return this.domicilioRepository.save(domicilio);
    }


}

package com.example.proyectoIntegrador.persistence.repository;

import com.example.proyectoIntegrador.persistence.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio,Integer> {
}

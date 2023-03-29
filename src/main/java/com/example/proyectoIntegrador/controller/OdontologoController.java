package com.example.proyectoIntegrador.controller;

import com.example.proyectoIntegrador.persistence.entity.Odontologo;
import com.example.proyectoIntegrador.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(OdontologoController.class);
    @Autowired
    private OdontologoService odontologoService;
    @PostMapping("/")
    public ResponseEntity<String> registrarOdontologo(@RequestBody Odontologo odontologo){

        ResponseEntity<String> response = null;

        if(odontologoService.guardar(odontologo)!= null){
            log.info("El odontologo se registro exitosamente");
            response = ResponseEntity.ok("El odontologo fue registrado con exito");
        }else {
            response = ResponseEntity.internalServerError().body("Ocurrio un error al registrar un nuevo odontologo");
        }

        return response;
    }
    @GetMapping("/")
    public ResponseEntity<List<Odontologo>> listarOdontologos(){

        return ResponseEntity.ok(odontologoService.listar());

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdonto(@PathVariable Integer id){

        odontologoService.eliminarPorId(id);

        return ResponseEntity.ok("Se elimino un odontologo");
    }

    @PutMapping("/")
    public ResponseEntity<String> modificarOdontologo(@RequestBody Odontologo odontologo){

            odontologoService.modificar(odontologo);
            return ResponseEntity.ok().build();
    }


}

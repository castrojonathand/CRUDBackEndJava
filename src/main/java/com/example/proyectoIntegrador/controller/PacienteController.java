package com.example.proyectoIntegrador.controller;

import com.example.proyectoIntegrador.persistence.entity.Paciente;
import com.example.proyectoIntegrador.service.PacienteService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(PacienteController.class);
    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/")
    public ResponseEntity<String> agregarPaciente(@RequestBody Paciente paciente){

        ResponseEntity<String> response = null;


        if (pacienteService.guardar(paciente)!= null){
            log.info("el paciente se registro exitosamente");

//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
//            LocalDateTime dateTimeFormatted = LocalDateTime.parse(paciente.getFechaAlta(), formatter);

            response = ResponseEntity.ok("Paciente registrado exitosamente");

        }else {
            response = ResponseEntity.internalServerError().body(("Ocurrio un error al ingresar un paciente"));
        }
        return response;
    }

     @GetMapping("/")
    public ResponseEntity<List<Paciente>> listarPacientes(){

        return ResponseEntity.ok(pacienteService.listar());
     }

     @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPacientePodId(@PathVariable Integer id){


        pacienteService.eliminarPorId(id);

        return ResponseEntity.ok("el paciente se elimino exitosamente");

     }

    @PutMapping("/")
    public ResponseEntity<String> modificarPaciente(@RequestBody Paciente paciente) throws NoSuchFieldException {

        pacienteService.modificar(paciente);

        return ResponseEntity.ok("El paciente se modifico correctamente");
    }





}

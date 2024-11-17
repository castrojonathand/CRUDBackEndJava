package com.example.proyectoIntegrador.controller;

import com.example.proyectoIntegrador.persistence.entity.Turno;
import com.example.proyectoIntegrador.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// import java.util.logging.LogManager;
// import java.util.logging.Logger;

@RestController
@RequestMapping("/turno")
@CrossOrigin(origins = "http://localhost:8080")
public class TurnoController {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(TurnoController.class);
    @Autowired
    private TurnoService turnoService;

    @PostMapping("/")
    public ResponseEntity<String> agregarTurno(@RequestBody Turno turno) {

        log.info("el Turno se registro exitosamente");
        //este bloke retorna en postman un string confirmando el registro
        System.out.println(turno.toString());
        ResponseEntity<String> response;
        turnoService.guardar(turno);

        response = ResponseEntity.ok("Turno registrado exitosamente");
        System.out.println(turno.toString());
        return response;

    }
        //Este retorna en postman el objeto turno completo.
//        return = ResponseEntity.ok(turnoService.guardar(turno));
 //            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
//            LocalDateTime dateTimeFormatted = LocalDateTime.parse(paciente.getFechaAlta(), formatter);
//    }
    @GetMapping("/")
    public ResponseEntity<List<Turno>> listaTurnos(){

        return ResponseEntity.ok(turnoService.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Integer id){

        System.out.println(id);
        turnoService.eliminarPorId(id);

        return ResponseEntity.ok("El turno se elimio no exito");
    }




}

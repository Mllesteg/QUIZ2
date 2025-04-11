package com.example.TallerParqueadero.Controller;

import com.example.TallerParqueadero.Model.reserva_parqueadero;
import com.example.TallerParqueadero.Service.reserva_parqueaderoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva_parqueadero")
public class reserva_parqueaderoController {

    @Autowired
    private reserva_parqueaderoService reservaService;

    @PostMapping
    public ResponseEntity<reserva_parqueadero> guardar(@RequestBody reserva_parqueadero reserva) {
        return ResponseEntity.ok(reservaService.guardar(reserva));
    }

    @GetMapping
    public ResponseEntity<List<reserva_parqueadero>> listar() {
        return ResponseEntity.ok(reservaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<reserva_parqueadero> obtenerPorId(@PathVariable Long id) {
        return reservaService.buscarPorid(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        if (reservaService.buscarPorid(id).isPresent()) {
            reservaService.eliminar(id);
            return ResponseEntity.ok("Eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID no encontrado");
        }
    }
}

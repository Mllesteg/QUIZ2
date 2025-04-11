package com.example.TallerParqueadero.Controller;

import com.example.TallerParqueadero.Model.reserva_zona;
import com.example.TallerParqueadero.Service.reserva_zonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva_zona")
public class reserva_zonaController {

    @Autowired
    private reserva_zonaService reservaZonaService;

    // Crear una nueva reserva de zona
    @PostMapping
    public ResponseEntity<reserva_zona> guardar(@RequestBody reserva_zona reserva) {
        return ResponseEntity.ok(reservaZonaService.guardar(reserva));
    }

    // Listar todas las reservas de zona
    @GetMapping
    public ResponseEntity<List<reserva_zona>> listar() {
        return ResponseEntity.ok(reservaZonaService.listar());
    }

    // Obtener una reserva de zona por ID
    @GetMapping("/{id}")
    public ResponseEntity<reserva_zona> obtenerPorId(@PathVariable Long id) {
        return reservaZonaService.buscarPorid(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una reserva de zona por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        if (reservaZonaService.buscarPorid(id).isPresent()) {
            reservaZonaService.eliminar(id);
            return ResponseEntity.ok("Eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID no encontrado");
        }
    }

    // Obtener reservas con detalles por fecha
    @GetMapping("/detalles/{fecha}")
    public ResponseEntity<List<Object[]>> obtenerReservasConDetallePorFecha(@PathVariable String fecha) {
        List<Object[]> reservas = reservaZonaService.obtenerReservasConDetallePorFecha(fecha);
        if (reservas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(reservas);
    }
}

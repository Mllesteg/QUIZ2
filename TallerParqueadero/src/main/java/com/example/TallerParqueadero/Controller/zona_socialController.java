package com.example.TallerParqueadero.Controller;

import com.example.TallerParqueadero.Model.zona_social;
import com.example.TallerParqueadero.Service.zona_socialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zona_social")
public class zona_socialController {

    @Autowired
    private zona_socialService zonaSocialService;

    @PostMapping
    public ResponseEntity<zona_social> guardar(@RequestBody zona_social zona) {
        return ResponseEntity.ok(zonaSocialService.guardar(zona));
    }

    @GetMapping
    public ResponseEntity<List<zona_social>> listar() {
        return ResponseEntity.ok(zonaSocialService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<zona_social> obtenerPorId(@PathVariable long id) {
        return zonaSocialService.buscarPorid(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<zona_social> actualizar(@PathVariable long id, @RequestBody zona_social nuevaZona) {
        return zonaSocialService.buscarPorid(id)
                .map(z -> {
                    z.setNombre(nuevaZona.getNombre());
                    z.setCapacidad(nuevaZona.getCapacidad());
                    // Agrega más setters si tu entidad tiene más atributos
                    return ResponseEntity.ok(zonaSocialService.guardar(z));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable long id) {
        if (zonaSocialService.buscarPorid(id).isPresent()) {
            zonaSocialService.eliminar(id);
            return ResponseEntity.ok("✅ Eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("❌ ID no encontrado");
        }
    }
}

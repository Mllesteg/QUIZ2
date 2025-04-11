package com.example.TallerParqueadero.Controller;

import com.example.TallerParqueadero.Model.propietario;
import com.example.TallerParqueadero.Service.propietarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propietarios")
@RequiredArgsConstructor
public class propietarioController {

    private final propietarioService service;

    @PostMapping
    public ResponseEntity<propietario> guardar(@RequestBody propietario p) {
        return ResponseEntity.ok(service.guardar(p));
    }

    @GetMapping
    public ResponseEntity<List<propietario>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<propietario> obtenerPropietario(@PathVariable Long id) {
        return service.buscarPorid(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        if (service.buscarPorid(id).isPresent()) {
            service.eliminar(id);
            return ResponseEntity.ok("Eliminado correctamente");
        } else {
            return ResponseEntity.status(404).body("ID no encontrado");
        }
    }
}

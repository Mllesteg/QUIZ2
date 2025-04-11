package com.example.TallerParqueadero.Controller;

import com.example.TallerParqueadero.Model.visitante;
import com.example.TallerParqueadero.Service.visitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitante")
public class visitanteController {

    @Autowired
    private visitanteService visitanteService;

    @PostMapping
    public ResponseEntity<visitante> guardar(@RequestBody visitante visitante) {
        return ResponseEntity.ok(visitanteService.guardar(visitante));
    }

    @GetMapping
    public ResponseEntity<List<visitante>> listar() {
        return ResponseEntity.ok(visitanteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<visitante> obtenerPorId(@PathVariable Long id) {
        return visitanteService.buscarPorid(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        if (visitanteService.buscarPorid(id).isPresent()) {
            visitanteService.eliminar(id);
            return ResponseEntity.ok("Eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID no encontrado");
        }
    }
}

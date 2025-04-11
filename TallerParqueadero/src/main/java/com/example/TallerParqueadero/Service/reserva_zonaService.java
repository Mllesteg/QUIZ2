package com.example.TallerParqueadero.Service;

import com.example.TallerParqueadero.Model.reserva_zona;
import com.example.TallerParqueadero.Repository.reserva_zonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class reserva_zonaService {

    @Autowired
    private reserva_zonaRepository reservaZonaRepository;

    // Guardar una nueva reserva de zona
    public reserva_zona guardar(reserva_zona reserva) {
        return reservaZonaRepository.save(reserva);
    }

    // Obtener todas las reservas de zona
    public List<reserva_zona> listar() {
        return reservaZonaRepository.findAll();
    }

    // Eliminar una reserva de zona por ID
    public void eliminar(long id) {
        reservaZonaRepository.deleteById(id);
    }

    // Buscar una reserva de zona por ID
    public Optional<reserva_zona> buscarPorid(long id) {
        return reservaZonaRepository.findById(id);
    }

    // Obtener las reservas con detalles por fecha
    public List<Object[]> obtenerReservasConDetallePorFecha(String fecha) {
        return reservaZonaRepository.obtenerReservasConDetallePorFecha(fecha);
    }
}


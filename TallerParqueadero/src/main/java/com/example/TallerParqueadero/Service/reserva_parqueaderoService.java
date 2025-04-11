package com.example.TallerParqueadero.Service;

import com.example.TallerParqueadero.Model.reserva_parqueadero;
import com.example.TallerParqueadero.Repository.reserva_parqueaderoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class reserva_parqueaderoService {
    @Autowired
    public reserva_parqueaderoRepository reservaParqueaderoRepository;

    public reserva_parqueadero guardar(reserva_parqueadero reserva) {
        return reservaParqueaderoRepository.save(reserva);
    }

    public List<reserva_parqueadero> listar() {
        return reservaParqueaderoRepository.findAll();
    }

    public void eliminar(long id) {
        reservaParqueaderoRepository.deleteById(id);
    }
    public Optional<reserva_parqueadero> buscarPorid(long id){
        return reservaParqueaderoRepository.findById(id);
    }
}

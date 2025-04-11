package com.example.TallerParqueadero.Service;

import com.example.TallerParqueadero.Model.visitante;
import com.example.TallerParqueadero.Repository.visitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class visitanteService {
    @Autowired
    public visitanteRepository visitanteRepository;

    public visitante guardar(visitante visitante) {
        return visitanteRepository.save(visitante);
    }

    public List<visitante> listar() {
        return visitanteRepository.findAll();
    }

    public void eliminar(long id) {
        visitanteRepository.deleteById(id);
    }
    public Optional<visitante> buscarPorid(long id){
        return visitanteRepository.findById(id);
    }
}

package com.example.TallerParqueadero.Service;

import com.example.TallerParqueadero.Model.zona_social;
import com.example.TallerParqueadero.Repository.zona_socialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class zona_socialService {
    @Autowired
    public zona_socialRepository zonaSocialRepository;

    public zona_social guardar(zona_social zona) {
        return zonaSocialRepository.save(zona);
    }

    public List<zona_social> listar() {
        return zonaSocialRepository.findAll();
    }

    public void eliminar(long id) {
        zonaSocialRepository.deleteById(id);
    }
    public Optional<zona_social> buscarPorid(long id){
        return zonaSocialRepository.findById(id);
    }
}

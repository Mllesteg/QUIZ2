package com.example.TallerParqueadero.Service;

import com.example.TallerParqueadero.Model.propietario;
import com.example.TallerParqueadero.Repository.propietarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class propietarioService {
    @Autowired
    public propietarioRepository propietarioRepository;

    public propietario guardar(propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    public List<propietario> listar() {
        return propietarioRepository.findAll();
    }

    public void eliminar(long id) {
        propietarioRepository.deleteById(id);
    }
    public Optional<propietario> buscarPorid(long id){
        return propietarioRepository.findById(id);
    }

}

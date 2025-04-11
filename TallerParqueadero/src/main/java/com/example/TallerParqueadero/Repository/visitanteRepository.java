package com.example.TallerParqueadero.Repository;
import com.example.TallerParqueadero.Model.visitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface visitanteRepository extends JpaRepository<visitante , Long> {
}

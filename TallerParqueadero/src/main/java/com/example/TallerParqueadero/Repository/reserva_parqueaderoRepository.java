package com.example.TallerParqueadero.Repository;
import com.example.TallerParqueadero.Model.reserva_parqueadero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface reserva_parqueaderoRepository extends JpaRepository<reserva_parqueadero , Long> {
}

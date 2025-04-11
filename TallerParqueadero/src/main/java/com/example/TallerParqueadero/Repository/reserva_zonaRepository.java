package com.example.TallerParqueadero.Repository;

import com.example.TallerParqueadero.Model.reserva_zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface reserva_zonaRepository extends JpaRepository<reserva_zona, Long> {

    @Query(value = "SELECT rz.id_reserva, rz.fecha, rz.hora_inicio, p.nombre as propietario, zs.nombre as zona_social " +
            "FROM reserva_zona rz " +
            "JOIN propietario p ON rz.id_propietario = p.id_propietario " +
            "JOIN zona_social zs ON rz.id_zona = zs.id_zona " +
            "WHERE rz.fecha = :fecha", nativeQuery = true)
    List<Object[]> obtenerReservasConDetallePorFecha(@Param("fecha") String fecha);
}

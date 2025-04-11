package com.example.TallerParqueadero.Repository;
import com.example.TallerParqueadero.Model.zona_social;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface zona_socialRepository extends JpaRepository<zona_social ,Long> {
}

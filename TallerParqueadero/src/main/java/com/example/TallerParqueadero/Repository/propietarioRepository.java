package com.example.TallerParqueadero.Repository;

import com.example.TallerParqueadero.Model.propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface propietarioRepository extends JpaRepository<propietario ,Long> {
   // @Query();
}

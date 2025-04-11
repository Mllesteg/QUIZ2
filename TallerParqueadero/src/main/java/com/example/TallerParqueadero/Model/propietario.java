package com.example.TallerParqueadero.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_propietario;
    private String nombre;
    private  String cedula;
    private LocalDate fecha_visita;
    private LocalTime hora_entrada;
}

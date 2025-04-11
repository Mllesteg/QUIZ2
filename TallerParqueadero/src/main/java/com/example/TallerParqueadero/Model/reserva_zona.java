package com.example.TallerParqueadero.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class reserva_zona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reserva;
    private LocalDate fecha;
    private LocalTime hora_inicio;

    @ManyToOne
    @JoinColumn(name ="id_propietario")
    private propietario propietario;

    @ManyToOne
    @JoinColumn(name ="id_zona")
    private zona_social zonaSocial;




}

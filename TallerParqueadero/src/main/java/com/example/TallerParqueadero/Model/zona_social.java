package com.example.TallerParqueadero.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class zona_social {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_zona;
    private  String nombre;
    private String ubicacion;
    private int capacidad;
}

package com.example.TallerParqueadero.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class visitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_visitante;
    private String nombre;
    private String cedula;
    private  String telefono;
    private String correo;

    @ManyToOne
    @JoinColumn(name ="id_propietario")
    private propietario propietario;
}

package com.example.gestion.des.reservations.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Builder @AllArgsConstructor
@Entity @Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime dateDebut;

    private LocalDateTime dateFin;

    @ManyToOne
    private Salle salle;
}

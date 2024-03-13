package com.example.gestion.des.reservations.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data
@Builder @AllArgsConstructor @NoArgsConstructor
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int numSalle;

    private int size;

    @OneToMany(mappedBy = "salle")
    private List<Reservation> reservations;
}

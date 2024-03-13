package com.example.gestion.des.reservations.dto;

import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data @AllArgsConstructor @NoArgsConstructor
public class UpdateReservationRequest {

    @FutureOrPresent(message = "dateFin should be greater than date now")
    private LocalDateTime newDateFin;
}
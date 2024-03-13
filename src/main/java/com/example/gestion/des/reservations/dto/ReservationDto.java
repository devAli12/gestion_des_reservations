package com.example.gestion.des.reservations.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor @Builder
@Data
public class ReservationDto {

    @NotNull(message = "dateDebut shouldn't null")
    private LocalDateTime dateDebut;

    @NotNull(message = "dateFin shouldn't null")
    @FutureOrPresent(message = "dateFin should be greater than date now")
    private LocalDateTime dateFin;
}

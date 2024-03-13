package com.example.gestion.des.reservations.service;

import com.example.gestion.des.reservations.dto.SalleDto;

import java.time.LocalDateTime;

public interface IReservationService {

     SalleDto reserveSalle(LocalDateTime dateDebut , LocalDateTime dateFin);

     void deleteReservation(int id);

     void updateReservation(int id,LocalDateTime dateFin);
}

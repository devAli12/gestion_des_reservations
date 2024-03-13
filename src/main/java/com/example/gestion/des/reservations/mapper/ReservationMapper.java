package com.example.gestion.des.reservations.mapper;

import com.example.gestion.des.reservations.dto.ReservationDto;
import com.example.gestion.des.reservations.entity.Reservation;

public class ReservationMapper {

    public static Reservation mapToReservation(ReservationDto reservationDto){
        return Reservation.builder().dateFin(reservationDto.getDateFin())
                .dateDebut(reservationDto.getDateDebut()).build();
    }

    public static ReservationDto mapToReservationDto(Reservation reservation){
        return ReservationDto.builder().dateFin(reservation.getDateFin())
                .dateDebut(reservation.getDateDebut()).build();
    }
}


package com.example.gestion.des.reservations.service.impl;

import com.example.gestion.des.reservations.dto.SalleDto;
import com.example.gestion.des.reservations.entity.Reservation;
import com.example.gestion.des.reservations.entity.Salle;
import com.example.gestion.des.reservations.exception.AucunSalleDisponibleException;
import com.example.gestion.des.reservations.exception.InvalidDateFinException;
import com.example.gestion.des.reservations.mapper.SalleMapper;
import com.example.gestion.des.reservations.repository.ReservationRepository;
import com.example.gestion.des.reservations.exception.ResourceNotFoundException;
import com.example.gestion.des.reservations.service.IReservationService;
import com.example.gestion.des.reservations.service.ISalleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service @AllArgsConstructor
public class ReservationService implements IReservationService {

    private final ReservationRepository reservationRepository;

    private final ISalleService iSalleService;
    @Override
    public SalleDto reserveSalle(LocalDateTime dateDebut, LocalDateTime dateFin) {
       List<SalleDto> salles = iSalleService.getAllSalleDisponibles(dateDebut);
       if(salles.isEmpty())
           throw new AucunSalleDisponibleException("aucun salle disponible pour le moment");
       Salle salle = iSalleService.getSalle(salles.get(0).getNumSalle());
       Reservation reservation = Reservation.builder()
                            .dateDebut(dateDebut)
                           .dateFin(dateFin)
                           .salle(salle).build();
       reservationRepository.save(reservation);
       return SalleMapper.mapToSalleDto(salle);
    }

    @Override
    public void deleteReservation(int id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("reservation","id",Integer.toString(id)));
        reservationRepository.deleteById(id);
    }

    @Override
    public void updateReservation(int id, LocalDateTime newDateFin) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("reservation","id",Integer.toString(id)));
        if (newDateFin.isBefore(reservation.getDateFin())) {
            throw new InvalidDateFinException("date fin que choisi est inférieure a ancien date fin");
        }
        reservation.setDateFin(newDateFin);
        reservationRepository.save(reservation);

    }

}

package com.example.gestion.des.reservations.repository;

import com.example.gestion.des.reservations.entity.Reservation;
import com.example.gestion.des.reservations.entity.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

}

package com.example.gestion.des.reservations.repository;

import com.example.gestion.des.reservations.entity.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SalleRepository extends JpaRepository<Salle,Integer> {
    @Query("SELECT s FROM Salle s WHERE s.id NOT IN (SELECT r.salle.id FROM Reservation r) OR NOT EXISTS (SELECT r.id FROM Reservation r WHERE r.salle.id = s.id AND r.dateFin > :givenDate)")
    Optional<List<Salle>> findSallesWithoutReservationOrWithDateFinBefore(@Param("givenDate") LocalDateTime givenDate);
     Optional<Salle> findByNumSalle(int numSalle);
}

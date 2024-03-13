package com.example.gestion.des.reservations.service;

import com.example.gestion.des.reservations.dto.SalleDto;
import com.example.gestion.des.reservations.entity.Salle;

import java.time.LocalDateTime;
import java.util.List;

public interface ISalleService {
    List<SalleDto> getAllSalleDisponibles(LocalDateTime date);
    Salle getSalle(int numSalle);
    void addSalle(SalleDto salleDto);
    List<SalleDto> getAllSales();
}

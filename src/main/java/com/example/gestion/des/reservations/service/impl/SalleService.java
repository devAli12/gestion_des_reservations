package com.example.gestion.des.reservations.service.impl;

import com.example.gestion.des.reservations.dto.SalleDto;
import com.example.gestion.des.reservations.entity.Salle;
import com.example.gestion.des.reservations.exception.AucunSalleDisponibleException;
import com.example.gestion.des.reservations.mapper.SalleMapper;
import com.example.gestion.des.reservations.exception.ResourceNotFoundException;
import com.example.gestion.des.reservations.repository.SalleRepository;
import com.example.gestion.des.reservations.service.ISalleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class SalleService implements ISalleService {

    private final SalleRepository salleRepository;
    @Override
    public List<SalleDto> getAllSalleDisponibles(LocalDateTime date) {
       List<Salle> salles = salleRepository.findSallesWithoutReservationOrWithDateFinBefore(date)
               .orElseThrow(()->new AucunSalleDisponibleException("Aucun salle disponible pour le moment"));
       List<SalleDto> salleDtos= new ArrayList<>();
       for(Salle salle :salles)  salleDtos.add(SalleMapper.mapToSalleDto(salle));
       return salleDtos;
    }

    @Override
    public Salle getSalle(int numSalle) {
        return salleRepository.findByNumSalle(numSalle)
                .orElseThrow(()->new ResourceNotFoundException("salle","numSale",Integer.toString(numSalle)));
    }

    @Override
    public void addSalle(SalleDto salleDto) {
        Salle salle = SalleMapper.mapToSalle(salleDto);
        salleRepository.save(salle);
    }

    @Override
    public List<SalleDto> getAllSales() {
        List<Salle> salles = salleRepository.findAll();
        List<SalleDto> salleDtos = new ArrayList<>();
        for (Salle salle:salles) salleDtos.add(SalleMapper.mapToSalleDto(salle));
        return salleDtos;
    }

}

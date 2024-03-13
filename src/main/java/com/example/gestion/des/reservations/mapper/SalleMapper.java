package com.example.gestion.des.reservations.mapper;

import com.example.gestion.des.reservations.dto.SalleDto;
import com.example.gestion.des.reservations.entity.Salle;

public class SalleMapper {

    public static Salle mapToSalle(SalleDto salleDto){
        return Salle.builder()
                .numSalle(salleDto.getNumSalle())
                .size(salleDto.getSize()).build();
    }

    public static SalleDto mapToSalleDto(Salle salle){
        return SalleDto.builder()
                .numSalle(salle.getNumSalle())
                .size(salle.getSize()).build();
    }
}

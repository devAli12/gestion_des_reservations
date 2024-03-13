package com.example.gestion.des.reservations.controller;


import com.example.gestion.des.reservations.constants.SalleConstants;
import com.example.gestion.des.reservations.dto.ResponseDto;
import com.example.gestion.des.reservations.dto.SalleDto;
import com.example.gestion.des.reservations.service.ISalleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/salles")
@AllArgsConstructor
public class SalleController {

    private final ISalleService iSalleService;

    @GetMapping("/disponible")
    public ResponseEntity<List<SalleDto>> getDisponibleSalles(){
        List<SalleDto> salleDtos = iSalleService.getAllSalleDisponibles(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.OK).body(salleDtos);
    }

    @GetMapping
    public ResponseEntity<List<SalleDto>> getAllSalles(){
        List<SalleDto> salleDtos = iSalleService.getAllSales();
        return ResponseEntity.status(HttpStatus.OK).body(salleDtos);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> create( @RequestBody @Valid SalleDto salleDto){
        iSalleService.addSalle(salleDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(SalleConstants.STATUS_201,SalleConstants.MESSAGE_201));
    }


}

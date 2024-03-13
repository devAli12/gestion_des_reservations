package com.example.gestion.des.reservations.controller;


import com.example.gestion.des.reservations.constants.ReservationConstants;
import com.example.gestion.des.reservations.dto.ReservationDto;
import com.example.gestion.des.reservations.dto.ResponseDto;
import com.example.gestion.des.reservations.dto.SalleDto;
import com.example.gestion.des.reservations.dto.UpdateReservationRequest;
import com.example.gestion.des.reservations.service.IReservationService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("reservations")
@AllArgsConstructor
public class ReservationController {

    private final IReservationService iReservationService;

    @Operation(summary = "Delete Reservation by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted reservation"),
    })


   @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteReservation(@PathVariable("id") int id){
         iReservationService.deleteReservation(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(ReservationConstants.STATUS_200,ReservationConstants.MESSAGE_200));
   }

    @Operation(summary = "Reserve Salle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully reserved salle")
    })

   @PostMapping
    public ResponseEntity<SalleDto> reserveSalle(@RequestBody @Valid ReservationDto reservationDto){
       SalleDto salleDto = iReservationService.reserveSalle(reservationDto.getDateDebut(),reservationDto.getDateFin());
       return ResponseEntity.status(HttpStatus.CREATED)
               .body(salleDto);
   }

    @Operation(summary = "Update Reservation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated reservation"),
    })
   @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateReservation(@PathVariable int id, @RequestBody @Valid UpdateReservationRequest updateReservationRequest){
       iReservationService.updateReservation(id,updateReservationRequest.getNewDateFin());
       return ResponseEntity.status(HttpStatus.OK)
               .body(new ResponseDto(ReservationConstants.STATUS_200,ReservationConstants.MESSAGE_200));
   }
}

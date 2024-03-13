package com.example.gestion.des.reservations.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data @Builder
public class SalleDto {
    private int numSalle;
    @Min(value = 10,message = "size should greater than 10")
    private int size;
}

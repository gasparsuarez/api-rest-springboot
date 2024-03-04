package com.devity.backend.domain.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateUserDto {
    String id;
    @NotBlank(message =  "Is required")
    String name;
}

package com.devity.backend.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
public class CreateUserDto {
    @NotBlank(message = "is required")
    String id;
    @NotBlank(message = "is required")
    String name;
}

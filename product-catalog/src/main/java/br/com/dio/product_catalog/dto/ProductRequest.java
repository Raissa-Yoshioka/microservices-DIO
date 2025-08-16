package br.com.dio.product_catalog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequest(
    @NotBlank String name,
    @NotBlank String description,
    @NotNull double price
) {
}

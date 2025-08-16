package br.com.dio.product_catalog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequest(
    Long id,

    @NotBlank(message = "O campo 'nome' percisa estar preenchido") 
    String name,

    @NotBlank(message = "O campo 'descrição' precisa estar preenchido")
    String description,

    @NotNull 
    @Positive
    double price
) {
}

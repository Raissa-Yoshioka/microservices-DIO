package br.com.dio.order_simulation.dto;

public record ProductDTO(
    Long id,
    String name,
    String description,
    double price
) {
}

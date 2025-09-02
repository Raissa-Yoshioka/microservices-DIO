package br.com.dio.order_simulation.dto;

public record OrderProductDTO(
    Long productId,
    int qtt,
    double unityPrice
) {
}

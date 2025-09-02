package br.com.dio.order_simulation.dto;

import java.util.List;

public record OrderSimulationDTO(
    List<OrderProductDTO> products,
    double totalPrice
) {
}

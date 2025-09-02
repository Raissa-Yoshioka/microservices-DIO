package br.com.dio.order_simulation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.order_simulation.ProductClient.ProductFeignClient;
import br.com.dio.order_simulation.dto.OrderProductDTO;
import br.com.dio.order_simulation.dto.OrderSimulationDTO;
import br.com.dio.order_simulation.dto.ProductDTO;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/pedidos")
public class OrderController {

    private ProductFeignClient productClient;

    public OrderController(ProductFeignClient productClient) {
        this.productClient = productClient;
    }

    @PostMapping("/simulation")
    public ResponseEntity<OrderSimulationDTO> orderSimulation(@RequestBody List<Long> productsID) {
        List<OrderProductDTO> listItems = new ArrayList<>();
        double total = 0;

        for (Long idTarget : productsID) {
            ProductDTO productTarget = productClient.getById(idTarget);
            if (productTarget == null) {
                return ResponseEntity.noContent().build();
            }

            OrderProductDTO product = new OrderProductDTO(productTarget.id(), 1, productTarget.price());
            listItems.add(product);
            total += productTarget.price();
        }

        OrderSimulationDTO order = new OrderSimulationDTO(listItems, total);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        List<ProductDTO> products = productClient.listProducts();
        return ResponseEntity.ok(products);
    }
    
    
}

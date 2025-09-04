package br.com.dio.order_simulation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.order_simulation.ProductClient.ProductFeignClient;
import br.com.dio.order_simulation.dto.OrderProductDTO;
import br.com.dio.order_simulation.dto.ProductDTO;
import br.com.dio.order_simulation.model.Order;
import br.com.dio.order_simulation.repository.OrderRepository;

@RestController
@RequestMapping("/pedidos")
public class OrderController {

    private ProductFeignClient productClient;
    private OrderRepository orderRepository;

    public OrderController(ProductFeignClient productClient, OrderRepository orderRepository) {
        this.productClient = productClient;
        this.orderRepository = orderRepository;
    }

    @PostMapping("/criar")
    public ResponseEntity<Order> orderSimulation(@RequestBody List<Long> productsID) {
        List<OrderProductDTO> listItems = new ArrayList<>();
        double total = 0;
        var order = new Order();

        for (Long idTarget : productsID) {
            ProductDTO productTarget = productClient.getById(idTarget);
            if (productTarget == null) {
                return ResponseEntity.noContent().build();
            }
            OrderProductDTO product = new OrderProductDTO(productTarget.id(), 1);
            listItems.add(product);
            total += productTarget.price();
        }

        order.setProducts(productsID);
        order.setTotalPrice(total);
        orderRepository.save(order);

        return ResponseEntity.ok(order);
    }

    @GetMapping
    public List<Order> listOrders() {
        return orderRepository.findAll();
    }
    
}

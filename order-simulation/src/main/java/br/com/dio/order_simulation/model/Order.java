package br.com.dio.order_simulation.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    List<Long> products = new ArrayList<>();
    double totalPrice;
    
    public Order() {
    }

    public Order(Long id, List<Long> products, double totalPrice) {
        this.id = id;
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public List<Long> getProducts() {
        return products;
    }
    public void setProducts(List<Long> products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}

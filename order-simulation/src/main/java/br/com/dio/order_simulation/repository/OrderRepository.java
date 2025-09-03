package br.com.dio.order_simulation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dio.order_simulation.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

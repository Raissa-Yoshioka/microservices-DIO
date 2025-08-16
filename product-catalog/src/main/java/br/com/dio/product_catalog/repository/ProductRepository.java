package br.com.dio.product_catalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dio.product_catalog.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    // Métodos personalizados
    List<Product> findByNameContaining(String name);
}

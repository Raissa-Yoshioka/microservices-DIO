package br.com.dio.product_catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dio.product_catalog.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

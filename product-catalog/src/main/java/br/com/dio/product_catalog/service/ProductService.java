package br.com.dio.product_catalog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.dio.product_catalog.exception.ProductNotFoundException;
import br.com.dio.product_catalog.model.Product;
import br.com.dio.product_catalog.repository.ProductRepository;

@Service
public class ProductService {

    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    public Product findProductByID(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException("O produto com id " + id + " não foi encontrado."));
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("O produto com id " + id + "não foi encontrado.");
        }
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("O produto com o id " + id + " não foi encontrado."));
        
        // Atualizar os campos
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());

        // Salvar alterações
        return productRepository.save(existingProduct);
    }

    // Métodos personalizados
    public List<Product> findProductByName(String name) {
        return productRepository.findByNameContaining(name);
    }
}

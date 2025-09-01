package br.com.dio.product_catalog.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.product_catalog.dto.ProductRequest;
import br.com.dio.product_catalog.model.Product;
import br.com.dio.product_catalog.service.ProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        var newProduct = new Product();
        BeanUtils.copyProperties(productRequest, newProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(newProduct));
    }

    @GetMapping
    public ResponseEntity<List<Product>> listProducts() {
        List<Product> productsList = productService.listProducts();
        if (productsList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(productsList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductByID(@PathVariable Long id) {
        Product targetProduct = productService.findProductByID(id);
        return ResponseEntity.ok(targetProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductRequest productRequest) {
        var auxProduct = new Product();
        BeanUtils.copyProperties(productRequest, auxProduct);
        Product updatedProduct = productService.updateProduct(id, auxProduct);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.accepted().build();
    }

}

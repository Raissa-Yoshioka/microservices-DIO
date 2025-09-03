package br.com.dio.order_simulation.ProductClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.dio.order_simulation.dto.ProductDTO;

@FeignClient(name = "product-catalog")
public interface ProductFeignClient {

    @GetMapping("/produtos/{id}")
    ProductDTO getById(@PathVariable("id") Long id);
}

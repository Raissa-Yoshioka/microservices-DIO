package br.com.dio.order_simulation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class OrderSimulationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderSimulationApplication.class, args);
	}

}

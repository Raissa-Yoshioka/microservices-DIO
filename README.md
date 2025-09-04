# Microservices DIO - Desafio NTT Data
## Desafio de Projeto final do bootcamp NTT DATA da DIO

![Java](https://img.shields.io/badge/Java-21-royalblue?style=for-the-badge&logo=openjdk)
!Maven(https://img.shields.io/badge/Maven-darkred?style=for-the-badge&logo=apachemaven)
!Spring Boot(https://img.shields.io/badge/Spring Boot-v3.5-darkgreen?style=for-the-badge&logo=spring)
![Docker](https://img.shields.io/badge/Docker-blue?style=for-the-badge&logo=docker)

Este projeto é uma aplicação baseada na arquitetura de microsserviços utilizando a linguagem Java com Spring Boot e Spring Cloud, simulando um sistema básico para catálogo de produtos e simulação de pedidos.

---

## Organização do Projeto

O projeto é separado em módulos, descritos abaixo:

- `API Gateway`, responsável pelo roteamento centralizado das requisições;
- `Discovery Service`, responsável pelo serviço de descoberta dos microserviços registrados utilizando _Eureka_;
- `Product Catalog`, microsserviço responsável por gerenciar os produtos;
- `Order Simulation`, microsserviço responsável pela simulação dos pedidos.

--- 

## Tecnologias Utilizadas

* Java 21
* Spring Boot 3.5
* Maven
* Spring Cloud Gateway
* Spring Cloud Netflix Eureka
* H2 Database (banco de dados em memória para testes)
* Docker e Docker Compose (para containerização dos microsserviços)

--- 

## Contexto dos Microsserviços

- Microsserviço 1: `product-catalog`
	*Realiza o catálogo de produtos, onde se cadastra, lista, consulta, atualiza e deleta produtos.
	* Endpoint: `/produtos`

- Microsserviço 2: `order-simulation`
	* Realiza a simulação da criação de um pedido com base em uma lista dos IDs dos produtos
	* Endpoint: `/pedidos`

## Portas de Acesso

- Service Discovery: 8761
- API Gateway: 8730
- Product Catalog: 8110
- Order Simulation: 8218



# Microservices DIO - Desafio NTT Data
## Desafio de Projeto final do bootcamp NTT DATA da DIO

![Java](https://img.shields.io/badge/Java-21-royalblue?style=for-the-badge&logo=openjdk)
![Maven](https://img.shields.io/badge/Maven-darkred?style=for-the-badge&logo=apachemaven)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-v3.5-darkgreen?style=for-the-badge&logo=spring)
![Docker](https://img.shields.io/badge/Docker-lightblue?style=for-the-badge&logo=docker)

Este projeto é uma aplicação baseada na arquitetura de microsserviços utilizando a linguagem Java com Spring Boot e Spring Cloud, simulando um sistema básico para catálogo de produtos e simulação de pedidos.

---

## Organização do Projeto

O projeto é separado em módulos, descritos abaixo:

- `API Gateway`, responsável pelo roteamento das requisições;
- `Discovery Service`, responsável pelo serviço de descoberta dos microsserviços registrados utilizando _Eureka_;
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

  	* Realiza o catálogo de produtos, onde se cadastra, lista, consulta, atualiza e deleta produtos.
	* Endpoint: `/produtos`

- Microsserviço 2: `order-simulation`

	* Realiza a simulação da criação de um pedido com base em uma lista dos IDs dos produtos.
	* Endpoint: `/pedidos`

## Portas de Acesso

- Service Discovery: `8761`
- API Gateway: `8730`
- Product Catalog: `8110`
- Order Simulation: `8218`

---

## Execução do Projeto

Certifique-se de ter o Java e Docker instalados na sua máquina, abra a pasta na sua IDE de preferência e abra o terminal no diretório raiz do projeto (`microservices-DIO`). Execute o seguinte comando que irá construir as imagens determinadas no arquivo `docker-compose.yml`:

```sh
	docker-compose up -d
```

Aguarde alguns minutos para os serviços serem registrados no servidor do _Eureka_ acessível em `http://localhost:8761` e os serviços `api-gateway`, `product-catalog` e `order-simulation` devem estar com o status `UP`.

E pronto! Você pode testar os endpoints com os seguintes métodos:

- Sobre o microsserviços `product-catalog`:

| Método| Endpoint			| Descrição					|
| ----- | -----------------	| ------------------------- |
| POST	| `/produtos`		| Cadastra um novo produto					|
| GET	| `/produtos`		| Retorna uma lista com todos os produtos cadastrados	|
| GET	| `/produtos/{id}`	| Retorna todos os detalhes do produto com o id		|
| PUT	| `/produtos/{id}`	| Atualiza as informações do produto cadastrado com o id	|
| DELETE| `/produtos/{id}`	| Remove um produto do sistema			|

- Sobre o microsserviços `order-simulation`:

| Método| Endpoint			| Descrição					|
| ----- | -----------------	| ------------------------- |
| POST	| `/pedidos/criar`	| Cadastra um novo pedido		|
| GET	| `/pedidos`	| Lista todos os pedidos cadastrados	|

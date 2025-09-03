FROM maven:3.9.11-eclipse-temurin-21-alpine AS gatewayBuild
# Definindo a imagem-base para a construção da aplicação, 
#   criando um objeto gatewayBuild

# Diretório de trabalho dentro container
WORKDIR /build

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
# Definindo a imagem-base para a execução da aplicação

WORKDIR /app

RUN addgroup --system spring && adduser --system spring spring
USER spring:spring

COPY --from=gatewayBuild /build/target/*.jar api-gateway.jar

# Declaração da porta utilizada pela aplicação
EXPOSE 8730

# Definindo uma variável de ambiente para o container
# SPRING_PROFILES_ACTIVE é uma variável reservada no Spring Framework
#       definindo quais perfis serão ativados durante a inicialização da aplicação
ENV SPRING_PROFILES_ACTIVE=docker

# Parâmetros para o ENTRYPOINT
ENTRYPOINT [ "java", "-jar", "api-gateway.jar" ]
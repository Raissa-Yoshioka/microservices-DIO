FROM maven:3.9.11-eclipse-temurin-21-alpine AS productCatalogBuild
# Definindo a imagem-base para a construção da aplicação, 
#   criando um objeto productCatalogBuild

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

COPY --from=productCatalogBuild /build/target/*.jar product-catalog.jar

# Declaração da porta utilizada pela aplicação
EXPOSE 8761

# Definindo uma variável de ambiente para o container
# SPRING_PROFILES_ACTIVE é uma variável reservada no Spring Framework
#       definindo quais perfis serão ativados durante a inicialização da aplicação
ENV SPRING_PROFILES_ACTIVE=docker

# Parâmetros para o ENTRYPOINT
CMD [ "java", "-jar", "product-catalog.jar" ]
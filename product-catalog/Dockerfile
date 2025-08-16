FROM openjdk:21-jdk-slim-buster
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/product-catalog-0.0.1-SNAPSHOT.jar productcatalog.jar
EXPOSE 8110
ENTRYPOINT exec java $JAVA_OPTS -jar productcatalog.jar
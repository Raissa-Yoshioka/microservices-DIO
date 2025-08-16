FROM openjdk:21-jdk-slim-buster
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/service-discovery-0.0.1-SNAPSHOT.jar servicediscovery.jar
EXPOSE 8761
ENTRYPOINT exec java $JAVA_OPTS -jar servicediscovery.jar
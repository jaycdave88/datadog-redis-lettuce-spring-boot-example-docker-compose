FROM adoptopenjdk/openjdk11

RUN apt-get update && \
    apt-get install -y wget && \
    apt-get install -y openjdk-17-jdk && \
    apt-get install -y nano && \
    apt-get install -y ca-certificates
    
VOLUME /redis-service
ARG JAR_FILE=target/redis-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} redis-service.jar
EXPOSE 8080

RUN wget -O dd-java-agent.jar https://dtdg.co/latest-java-tracer

ENTRYPOINT ["java", "-javaagent:/dd-java-agent.jar", "-jar", "/redis-service.jar"]
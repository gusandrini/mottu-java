# Etapa de build (usa Maven + JDK 17)
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de runtime (usa Temurin JDK 17 Alpine)
FROM eclipse-temurin:17-jdk-alpine
RUN adduser -h /home/gustavo -s /bin/sh -D gustavo
WORKDIR /home/gustavo
COPY --from=builder /app/target/*.jar app.jar
RUN chown gustavo:gustavo app.jar
USER gustavo
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

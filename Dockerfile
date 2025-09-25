# Etapa de build (usa Maven + JDK 17)
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de runtime (usa OpenJDK 17 slim fixado por digest)
FROM openjdk@sha256:1dcf4e3e3d45b2db87a8dd8f9f9897b4c7877d77d6c0f74d78d65b19f73e664b
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

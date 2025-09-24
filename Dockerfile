# Etapa de build (usa Maven com JDK 17)
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de runtime (usa JDK 17 oficial)
FROM eclipse-temurin:17
RUN adduser --home /home/gustavo --shell /bin/sh --disabled-password gustavo
WORKDIR /home/gustavo
COPY --from=builder /app/target/*.jar app.jar
RUN chown gustavo:gustavo app.jar
USER gustavo
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

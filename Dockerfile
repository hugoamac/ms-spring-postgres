# Etapa 1: Construir o aplicativo
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Rodar a aplicação
FROM openjdk:17-jdk-alpine
WORKDIR /app
ENV SPRING_DATASOURCE_URL "jdbc:postgresql://localhost:5432/postgres"
ENV SPRING_DATASOURCE_USERNAME "root"
ENV SPRING_DATASOURCE_PASSWORD "root"
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]

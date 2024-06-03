# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 AS build

COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

# Stage 2: Create the final image
FROM openjdk:17-jdk-slim

COPY --from=build /home/app/target/movie_manage-0.0.1-SNAPSHOT.jar /app/moviemanage.jar
WORKDIR /app
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/moviemanage.jar"]

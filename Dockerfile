#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#


FROM openjdk:11-jdk-slim
MAINTAINER NICO
COPY --from=build target/PortfolioNicoFrances-0.0.1-SNAPSHOT.jar  portfolioApp.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/portfolioApp.jar"]

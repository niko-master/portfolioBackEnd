
FROM amazoncorretto: 11-alpine-jdk
MAINTAINER NICO
COPY  target/PortfolioNicoFrances-0.0.1-SNAPSHOT.jar  portfolioApp.jar
ENTRYPOINT ["java","-jar","/portfolioApp.jar"]
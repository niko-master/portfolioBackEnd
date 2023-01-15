
FROM amazoncorretto: 11-alpine-jdk  //VERSION JAVA
MAINTAINER NICO //OWNER
COPY  target/PortfolioNicoFrances-0.0.1-SNAPSHOT.jar  portfolioApp.jar           //COPIA EL EMPAQUEADO Y LO SUBE
ENTRYPOINT ["java","-jar","/portfolioApp.jar"]                //ENTRADA
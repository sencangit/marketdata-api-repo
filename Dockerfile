FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /home/app

COPY ./pom.xml /home/app/pom.xml
COPY ./src/main/java/com/finance/marketdata/restservices/MarketdataRestservicesApplication.java /home/app/src/main/java/com/finance/marketdata/restservices/MarketdataRestservicesApplication.java

RUN mvn -f /home/app/pom.xml clean package

COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:17-jdk-slim
EXPOSE 8000
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]
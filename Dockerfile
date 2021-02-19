FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/catalog-service-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar", "app.jar"]

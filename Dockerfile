FROM openjdk:8-jdk-alpine
WORKDIR /demo
COPY SpringTomcat.jar ./demo/springtomcat.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","./demo/springtomcat.jar"]

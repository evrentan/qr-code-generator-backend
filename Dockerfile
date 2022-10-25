FROM gradle:7-jdk17-alpine AS build
COPY . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build 

FROM openjdk:17-alpine
EXPOSE 8082
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/qr-code-generator-backend-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/app/qr-code-generator-backend-1.0.0.jar"]
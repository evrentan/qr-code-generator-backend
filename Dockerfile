ARG APP_JAR=qr-code-generator-backend-1.0.0.jar
FROM gradle:7-jdk17-alpine AS build
COPY . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build 

FROM openjdk:17-alpine
ARG APP_JAR
ENV APP_JAR_ENV=$APP_JAR
EXPOSE 8081
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/${APP_JAR_ENV} /app/${APP_JAR_ENV}
ENTRYPOINT java -jar /app/${APP_JAR_ENV}
ARG APP_JAR=qr-code-generator-backend-1.0.0.jar

FROM amazoncorretto:21-alpine AS build
WORKDIR /home/gradle/src
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN --mount=type=cache,target=/root/.gradle ./gradlew build --no-daemon

FROM amazoncorretto:21-alpine
LABEL maintainer="Evren Tan"
LABEL application="qr-code-generator"
LABEL version="1.0.0"

ARG APP_JAR
ENV APP_JAR_ENV=$APP_JAR

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

WORKDIR /app
COPY --from=build --chown=spring:spring /home/gradle/src/build/libs/${APP_JAR_ENV} app.jar

EXPOSE 8081

HEALTHCHECK --interval=30s --timeout=3s \
  CMD wget --quiet --tries=1 --spider http://localhost:8081/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

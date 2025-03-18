FROM gradle:8.0-jdk17 AS build

WORKDIR /app

COPY . .

RUN ./gradlew clean build --no-daemon

FROM openjdk:17-alpine

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ARG PROFILE=hom
ENV SPRING_PROFILES_ACTIVE=${PROFILE}

CMD ["java", "-jar", "app.jar"]

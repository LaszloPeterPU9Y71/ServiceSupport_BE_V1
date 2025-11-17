# Stage 1: Build
FROM gradle:8.3.3-jdk20 AS build
WORKDIR /app

# Gradle fájlok másolása (cache optimalizálás)
COPY build.gradle settings.gradle ./
RUN gradle dependencies --no-daemon

# Forráskód másolása és build
COPY src ./src
RUN gradle bootJar --no-daemon

# Stage 2: Futó konténer
FROM eclipse-temurin:20-jre
WORKDIR /app

# Buildelt jar átmásolása
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
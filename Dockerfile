
FROM gradle:8.3.3-jdk20 AS build
WORKDIR /app


COPY build.gradle settings.gradle ./
RUN gradle dependencies --no-daemon


COPY src ./src
RUN gradle bootJar --no-daemon


FROM eclipse-temurin:20-jre
WORKDIR /app


COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
### BUILD ###
FROM maven:3.9.0-amazoncorretto-17 AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src
WORKDIR /build
RUN mvn package

### CREATE DOCKER IMAGE ###
FROM amazoncorretto:17.0.6
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/malib-api.jar /app/
EXPOSE 8080
ENTRYPOINT ["java","-jar","malib-api.jar"]
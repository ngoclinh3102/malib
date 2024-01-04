#FROM harbor.logixtek.com/logix.technology/maven:3.9.5-amazoncorretto-17 AS BUILD
#ARG http_proxy
#ENV http_proxy=${http_proxy}
#COPY settings.xml /usr/share/maven/conf/
#COPY settings.xml /root/.m2/
#WORKDIR /malib
#COPY pom.xml .
#COPY src .
#RUN mvn package
#
#FROM harbor.logixtek.com/logix.technology/amazoncorretto:17.0.9
#WORKDIR /malib/target
#COPY --from=BUILD /malib/target/malib-api-0.0.1.jar .
#EXPOSE 9900
#ENTRYPOINT ["java", "-jar", "malib-api-0.0.1.jar"]

FROM harbor.logixtek.com/logix.technology/alpine:latest
RUN ping repo.maven.apache.org
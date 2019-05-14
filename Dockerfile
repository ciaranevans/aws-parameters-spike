FROM maven:3.6.1-jdk-11 as build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
WORKDIR /usr/src/app
RUN mvn clean install

FROM adoptopenjdk/openjdk11:alpine-jre
COPY --from=build /usr/src/app/target/*.jar /usr/app/application.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/usr/app/application.jar"]
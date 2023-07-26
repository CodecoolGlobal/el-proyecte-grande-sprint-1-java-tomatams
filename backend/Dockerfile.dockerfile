### STAGE 1: Build ###

# build env
FROM node:18.14.0-alpine as react-build
WORKDIR /react_build
COPY ../frontend/package*.json /react_build
RUN npm install
COPY ../frontend /react_build
RUN npm run build -p /maven_build/src/main/resources/public

FROM maven:3.9.3-eclipse-temurin-17 AS java-build
WORKDIR /maven_build
COPY pom.xml /maven_build
COPY src /maven_build/src
RUN mvn -f pom.xml clean package

### STAGE 2: Run ###
FROM openjdk:17-alpine
VOLUME /tmp
EXPOSE 8080

COPY --from=java-build /maven_build/target/el-proyecte-grande-sprint-1-java-tomatams-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
### STAGE 1: Build ###
# build frontend
FROM node:18.14.0-alpine as react-build
WORKDIR /react_build
COPY ../frontend/package*.json /react_build
RUN npm install
COPY ../frontend /react_build
RUN npm run build

#build backend
FROM maven:3.9.3-eclipse-temurin-17 AS java-build
WORKDIR /maven_build
COPY ./backend/pom.xml /maven_build
RUN mvn dependency:resolve
COPY ./backend/src /maven_build/src
COPY --from=react-build /react_build/build ./src/main/resources/public
RUN mvn -f pom.xml clean package

### STAGE 2: Run ###
FROM eclipse-temurin:17.0.8_7-jre
VOLUME /tmp
EXPOSE 8080
COPY --from=java-build /maven_build/target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
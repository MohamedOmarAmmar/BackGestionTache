#FROM adoptopenjdk/openjdk11:alpine-jre
#ADD target/test-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","app.jar"]
#FROM openjdk:8-jdk-alpine
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
FROM adoptopenjdk/openjdk11:alpine-jre
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.doqtoor.test.TestApplication"]
FROM openjdk:17-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=out/artifacts/tarea2_jar/tarea2.jar
COPY ${JAR_FILE} tarea2.jar
ENTRYPOINT ["java","-jar","/tarea2.jar"]

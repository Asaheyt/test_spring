FROM openjdk:17-oracle
COPY build/libs/test-v0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
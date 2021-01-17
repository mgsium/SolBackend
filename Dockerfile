FROM openjdk:14
ADD target/api-0.0.1-SNAPSHOT.jar api-0.0.1-SNAPSHOT.jar
EXPOSE 8443
ENTRYPOINT ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]

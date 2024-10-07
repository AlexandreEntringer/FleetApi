FROM openjdk:17
ADD ./fleet-0.0.1-SNAPSHOT.jar fleet-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "fleet-0.0.1-SNAPSHOT.jar"]
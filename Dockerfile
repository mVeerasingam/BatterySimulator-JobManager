FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/BatterySimulator_JobManagerService-0.0.1-SNAPSHOT.jar /app
EXPOSE 8083
CMD ["java", "-jar", "BatterySimulator_JobManagerService-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=docker"]
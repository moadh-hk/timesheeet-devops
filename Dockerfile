FROM openjdk:8-jdk-alpine
EXPOSE 8082 
ADD target/timesheeet-devops-1.0.jar timesheeet-devops-1.0.jar
ENTRYPOINT ["java","jar","/timesheeet-devops-1.0.jar"]
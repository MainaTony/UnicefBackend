FROM openjdk:8
EXPOSE 8080
ADD target/scoring-portal.jar scoring-portal.jar
ENTRYPOINT ["java", "jar", "scoring-portal.jar"]
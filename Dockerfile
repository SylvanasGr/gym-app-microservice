FROM openjdk:17
EXPOSE 8080
ADD target/gym-app.jar gym-app.jar
ENTRYPOINT ["java","-jar","/gym-app.jar"]
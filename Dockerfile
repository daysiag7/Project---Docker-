FROM openjdk:10
VOLUME /main-app
ADD build/libs/loginproject-0.0.1-SNAPSHOT-plain.war app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar"]




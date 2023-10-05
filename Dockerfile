FROM openjdk:21
VOLUME /tmp
EXPOSE 8080
ADD ./target/apirest-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "/app.jar"]
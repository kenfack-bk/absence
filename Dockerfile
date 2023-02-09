FROM openjdk:17-jdk-alpine
VOLUME /tmp
EXPOSE 8080:9099
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD ./target/absence-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-jar", "/app/app.jar"]
FROM eclipse-temurin:21-alpine
ADD target/hello-v1.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/app.jar" ]
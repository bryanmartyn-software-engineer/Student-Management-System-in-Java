# Java runtime
FROM eclipse-temurin:17-jdk

# Set working directory in container
WORKDIR /app

# Copy local .jar file to the container
COPY target/student-management-system-1.0-SNAPSHOT.jar /app/student-management-system.jar

# Run the .jar file when the container starts
ENTRYPOINT ["java", "-jar", "student-management-system.jar"]

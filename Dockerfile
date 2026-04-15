# Java runtime
FROM eclipse-temurin:17-jdk

RUN apt-get update && apt-get install -y \
    libxext6 \
    libxrender1 \
    libxtst6 \
    libxi6 \
    && rm -rf /var/lib/apt/lists/*

# Set working directory in container
WORKDIR /app

# Copy local .jar file to the container
COPY target/student-management-system-1.0-SNAPSHOT.jar /app/student-management-system.jar
COPY lib/mysql-connector-j-9.3.0.jar /app/mysql-connector-j-9.3.0.jar

# To run the program via VcXsrv Windows X Server
ENV DISPLAY=host.docker.internal:0

# Run with both JARs in classpath (NOT using -jar)
ENTRYPOINT ["java", "-cp", "student-management-system.jar:mysql-connector-j-9.3.0.jar", "Main"]
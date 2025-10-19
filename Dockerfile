# Multi-stage build for Spring MVC application

# Stage 1: Build the application
FROM maven:3.9-eclipse-temurin-25-alpine AS build

WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Copy Docker-specific persistence.xml
COPY persistence-docker.xml ./src/META-INF/persistence.xml

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Create runtime image
FROM tomcat:11.0-jdk25

# Remove default webapps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the WAR file from build stage
COPY --from=build /app/target/CustomerManager.war /usr/local/tomcat/webapps/ROOT.war

# Create directory for persistence.xml if needed
RUN mkdir -p /usr/local/tomcat/conf

# Expose Tomcat port
EXPOSE 8080

# Set environment variables for database connection
ENV DB_HOST=mysql \
    DB_PORT=3306 \
    DB_NAME=sales \
    DB_USER=root \
    DB_PASSWORD=root

# Start Tomcat
CMD ["catalina.sh", "run"]

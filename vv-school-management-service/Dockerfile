# Use an OpenJDK base image
FROM openjdk:21

# Set the working directory
WORKDIR /app

# Copy Maven wrapper and project dependencies
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Pre-download dependencies
RUN ./mvnw dependency:resolve

# Copy the source code
COPY src ./src

# Expose the application port
EXPOSE 8080

# Run the application in development mode
CMD ["./mvnw", "spring-boot:run"]
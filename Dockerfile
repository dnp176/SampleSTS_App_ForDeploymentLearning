# Step 1: Build stage
FROM eclipse-temurin:17-jdk-alpine as build

# Set working directory
WORKDIR /app

# Copy Maven target folder contents
COPY target/SampleProject.jar app.jar

# Step 2: Run stage
FROM eclipse-temurin:17-jre-alpine

# Set working directory
WORKDIR /app

# Copy the built JAR from build stage
COPY --from=build /app/app.jar app.jar

# Expose application port
EXPOSE 8001

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

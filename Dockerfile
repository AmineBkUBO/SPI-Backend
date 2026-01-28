# ===========================
# Stage 1: Build the application
# ===========================
FROM gradle:8.5-jdk17 AS build

# Set workdir inside container
WORKDIR /app

# Copy Gradle wrapper and build files first for dependency caching
COPY gradle ./gradle
COPY gradlew .
COPY build.gradle .
COPY settings.gradle .

# Download dependencies (will be cached if build.gradle hasn't changed)
RUN ./gradlew dependencies --no-daemon

# Copy the source code
COPY src ./src

# Build the Spring Boot application (create executable jar)
RUN ./gradlew clean bootJar --no-daemon

# ===========================
# Stage 2: Run the application
# ===========================
FROM eclipse-temurin:17-jre-alpine

# Set workdir
WORKDIR /app

# Copy the jar from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the port your Spring Boot app runs on (default 8080)
EXPOSE 8080

# Run the Spring Boot jar
ENTRYPOINT ["java", "-jar", "app.jar"]
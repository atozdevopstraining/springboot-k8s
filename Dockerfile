# Use a minimal base JDK image
FROM eclipse-temurin:21-jre

# Set working directory
WORKDIR /app

# Copy the JAR file (built by Maven or Gradle)
COPY target/*.jar app.jar

# Expose the port your app runs on
EXPOSE 80

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]

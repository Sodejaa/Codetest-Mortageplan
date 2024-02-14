# Use an OpenJDK base image with Maven installed
FROM maven:3.8.3-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project
COPY . /app

# Build the application
RUN mvn clean package

# Set the classpath
ENV CLASSPATH=/app/target/classes

# Command to run the application
CMD ["java", "-classpath", "/app/target/classes", "MortagePlan"]

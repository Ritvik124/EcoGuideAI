# Stage 1: Build the WAR file using Maven and Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app

# Copy the pom.xml and download dependencies (caching step)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Deploy the built application to Tomcat 11 (requires Java 21)
FROM tomcat:11.0-jre21

# Clean the default Tomcat applications to keep the server lightweight
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the built WAR file from the builder stage
# We rename it to ROOT.war so the API is accessible directly at the domain root (e.g., https://your-backend.onrender.com/api/ask)
COPY --from=builder /app/target/EcoGuideAI.war /usr/local/tomcat/webapps/ROOT.war

# Render requires web services to bind to a port, Tomcat defaults to 8080
RUN sed -i "s|port=\"8005\"|port=\"-1\"|g" /usr/local/tomcat/conf/server.xml
EXPOSE 8080

# The base Tomcat image already includes the CMD to start the server (catalina.sh run)

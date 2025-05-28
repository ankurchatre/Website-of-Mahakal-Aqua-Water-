# Build stage
FROM maven:3.8.6-openjdk-11 AS builder
WORKDIR /app
COPY pom.xml .
COPY src /app/src
RUN mvn dependency:go-offline
RUN mvn clean package -DskipTests

# Final stage
FROM tomcat:11.0-jre17
COPY --from=builder /app/target/ROOT.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]
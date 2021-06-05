FROM maven:3.6.0-jdk-11

WORKDIR /app
COPY . .
RUN mvn clean install & mvn clean compile

ENTRYPOINT [ "mvn", "spring-boot:run" ]
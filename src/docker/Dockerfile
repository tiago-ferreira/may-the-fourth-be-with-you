FROM openjdk:8-jdk-alpine
# Required for starting application up.
RUN apk update && apk add bash

RUN mkdir -p /opt/app

ENV PROJECT_HOME /opt/app

COPY ./target/may-the-fourth-be-with-you.jar $PROJECT_HOME/may-the-fourth-be-with-you.jar

CMD ["java", "-Dspring.data.mongodb.uri=mongodb://may-the-fourth-be-with-you-mongo:27017/may-the-fourth-be-with-you", "-Djava.security.egd=file:/dev/./urandom","-jar","./may-the-fourth-be-with-you.jar"]

WORKDIR $PROJECT_HOME
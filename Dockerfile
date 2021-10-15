FROM openjdk:16
WORKDIR /app/
COPY ./* ./
RUN javac lab1.java

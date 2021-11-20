FROM openjdk:16
WORKDIR /app/
COPY ./* ./
RUN javac lab5.java

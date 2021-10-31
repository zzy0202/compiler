FROM openjdk:16
WORKDIR /app/
COPY ./* ./
RUN javac Lab3.java

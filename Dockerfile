FROM openjdk:15
WORKDIR /app/
COPY ./* ./
ENV CLASSPATH="antlr-4.9-complete.jar:$CLASSPATH"
RUN javac lab1.java


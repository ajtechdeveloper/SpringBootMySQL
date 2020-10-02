FROM openjdk:8-jdk

COPY /target/SpringBootMySQL-1.0.0.jar /data/SpringBootMySQL/SpringBootMySQL-1.0.0.jar

WORKDIR /data/SpringBootMySQL

RUN java -version

CMD ["java","-jar","SpringBootMySQL-1.0.0.jar"]

EXPOSE 4000-4001 
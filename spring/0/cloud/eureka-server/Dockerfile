FROM openjdk:12.0.2

EXPOSE 8761

ADD ./target/*.jar eureka-server.jar

ENTRYPOINT ["java","-jar","/eureka-server.jar"]

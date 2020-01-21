FROM openjdk:12.0.2

EXPOSE 8765

ADD ./target/*.jar gateway.jar

ENTRYPOINT ["java","-jar","/gateway.jar"]

FROM openjdk:12.0.2

EXPOSE 8765

ADD ./target/*.jar gateway.jar

ADD ./wait-for-it.sh wait-for-it.sh

#ENTRYPOINT ["java","-jar","/gateway.jar"]

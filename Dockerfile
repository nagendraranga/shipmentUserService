FROM openjdk:8
VOLUME /tmp
EXPOSE 9601
ARG JAR_FILE=target/shipmentUserService-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} shipmentuserserviceapp.jar
ENTRYPOINT ["java","-jar","/shipmentuserserviceapp.jar"]
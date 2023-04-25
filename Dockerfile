FROM amazoncorretto:17-alpine-jdk
MAINTAINER tommy
COPY target/backendnew-0.0.1-SNAPSHOT.jar backendnew-0.0.1-SNAPSHOT.jar
entrypoint ["java","-jar","/backendnew-0.0.1-SNAPSHOT.jar"]

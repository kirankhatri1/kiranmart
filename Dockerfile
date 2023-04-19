FROM eclipse-temurin:17-jdk-alpine
MAINTAINER kiranm khatri
COPY target/kiranmart-0.0.1-SNAPSHOT.jar kiranmart-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/kiranmart-0.0.1-SNAPSHOT.jar"]
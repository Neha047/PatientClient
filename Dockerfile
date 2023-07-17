FROM openjdk:18
EXPOSE 8081
ADD target/balcoprojectPatientClient.jar balcoprojectPatientClient.jar
ENTRYPOINT ["java","jar","/balcoprojectPatientClient.jar"]
FROM openjdk

EXPOSE 8080

ADD target/equation-calculation-0.0.1-SNAPSHOT.jar equation-calculation.jar

ENTRYPOINT ["java","-jar","equation-calculation.jar"]
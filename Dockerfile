FROM openjdk:11
#ADD build/libs/* dockerapp.jar
COPY "build/libs/williams-0.0.1-SNAPSHOT.jar" "dockerapp.jar"
ENTRYPOINT ["java","-jar","dockerapp.jar"]


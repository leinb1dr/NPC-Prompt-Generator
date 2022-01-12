FROM openjdk:17.0.1-jdk
ARG JAR_FILE=npc-prompt/build/libs/npc-prompt-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
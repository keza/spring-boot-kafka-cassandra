FROM openjdk:8
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod a+x /wait-for-it.sh
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
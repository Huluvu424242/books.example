FROM java:8-jdk
VOLUME /tmp
ADD @project.build.finalName@.jar app.jar
EXPOSE 9000  
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
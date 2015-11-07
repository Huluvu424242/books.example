FROM java:8
VOLUME /tmp
ADD ${project.build.finalName} app.jar  
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
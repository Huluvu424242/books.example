FROM java:8-jdk
VOLUME /tmp
ADD @project.build.finalName@.jar app.jar  
EXPOSE 8080
# install needed packages
RUN \
  export DEBIAN_FRONTEND=noninteractive && \
  apt-get update && \
  apt-get -y upgrade && \
  apt-get install -y less
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
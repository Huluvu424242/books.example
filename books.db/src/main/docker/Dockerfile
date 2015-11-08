# FROM java:8
# VOLUME /tmp
# ADD ${project.build.finalName}.jar app.jar  
# EXPOSE 8080
# RUN bash -c 'touch /app.jar'
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

FROM java:8
MAINTAINER FunThomas424242 (Thomas Schubert, funthomas424242@gmail.com)

ENV H2_RELEASE_DATE=2015-10-11

WORKDIR /tmp

# Install H2
RUN wget http://www.h2database.com/h2-$H2_RELEASE_DATE.zip && \
  unzip h2-$H2_RELEASE_DATE.zip && \
  rm -f h2-$H2_RELEASE_DATE.zip && \
  mv h2 /opt && \
  mkdir -p /opt/h2-data

# Expose ports.
#   - 1521: H2 Server
#   -   80: H2 Console
EXPOSE 1521

CMD java -cp /opt/h2/bin/h2*.jar org.h2.tools.Server -web -webAllowOthers -webPort 80 -tcp -tcpAllowOthers -tcpPort 1521 -baseDir /opt/h2-data

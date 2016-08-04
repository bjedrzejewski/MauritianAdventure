#Install Spring boot
FROM frolvlad/alpine-oraclejdk8:slim

#REDIS
# Install redis
RUN echo "http://dl-4.alpinelinux.org/alpine/v3.1/main" >> /etc/apk/repositories && \
    apk add --update redis=2.8.23-r0

VOLUME /tmp
ADD mauritian-adventure-0.0.1.jar app.jar
RUN sh -c 'touch /app.jar'

# supervisor base configuration
ENV PYTHON_VERSION=2.7.12-r0
ENV PY_PIP_VERSION=8.1.2-r0
ENV SUPERVISOR_VERSION=3.3.0

RUN apk update && apk add -u python=$PYTHON_VERSION py-pip=$PY_PIP_VERSION
RUN pip install supervisor==$SUPERVISOR_VERSION

COPY supervisord.conf /etc/supervisord.conf

EXPOSE 8080

ENTRYPOINT ["supervisord", "--nodaemon", "--configuration", "/etc/supervisord.conf"]
FROM gradle:4.2.1-jdk8-alpine
WORKDIR /code

USER root                # This changes default user to root
RUN chown -R gradle /app # This changes ownership of folder
USER gradle              # This changes the user back to the default user "gradle"
RUN gradle build --stacktrace

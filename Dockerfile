FROM registry.vdc.sky/skyq/tomcat:9-jre11

LABEL maintainer="Sky Q Client Services Team"

COPY target/boot-api.war "$CATALINA_WEBAPPS/api.war"

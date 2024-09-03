# Use uma imagem base do Maven com JDK 8 para construir o projeto
FROM maven:3.8.6-openjdk-8 AS builder

# Defina o diretório de trabalho
WORKDIR /

# Copie o pom.xml e o código-fonte
COPY pom.xml .
COPY src ./src

# Compile e empacote o aplicativo
RUN mvn clean package

# Use uma imagem base do Tomcat com JDK 8
FROM tomcat:9.0-jdk8
#FROM tomcat:8.5-jre8

# Copie o WAR gerado para o diretório webapps do Tomcat
COPY --from=builder target/jsn-desafio.war /usr/local/tomcat/webapps/

# Exponha a porta padrão do Tomcat
EXPOSE 8080

# Comando para iniciar o Tomcat
CMD ["catalina.sh", "run"]

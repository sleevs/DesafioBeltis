# Projeto Spring MVC com PostgreSQL e Tomcat

Este projeto é um exemplo de aplicação Spring MVC integrada com PostgreSQL e executada em um contêiner Tomcat. As instruções a seguir cobrem como iniciar o projeto utilizando Docker Compose.

## Pré-requisitos

Antes de começar, certifique-se de que você tem as seguintes ferramentas instaladas:

- [Java JDK 8 ou superior](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
- [Maven](https://maven.apache.org/download.cgi) (ou outro gerenciador de build de sua escolha)
- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Configuração do Projeto

### 1. Configuração do PostgreSQL

O PostgreSQL será executado em um contêiner Docker, conforme especificado no arquivo `docker-compose.yml`. O banco de dados será inicializado com as configurações fornecidas.

### 2. Configuração do Tomcat

O Tomcat também será executado em um contêiner Docker, e o arquivo `docker-compose.yml` configurará o Tomcat para expor a aplicação na porta 8080.

### 3. Configuração do Spring MVC

Certifique-se de que o seu projeto Spring MVC está configurado para conectar ao PostgreSQL. As configurações necessárias são especificadas no arquivo `application.properties` ou `application.yml`, dependendo do seu projeto.

### 4. Configuração do Docker Compose

O Docker Compose será usado para iniciar os contêineres PostgreSQL e Tomcat.

Crie um arquivo `docker-compose.yml` na raiz do seu projeto com o seguinte conteúdo:

```yaml
version: '3.8'

services:
  postgres:
    image: postgres:13
    container_name: postgres
    environment:
      POSTGRES_DB: your_database
      POSTGRES_USER: your_username
      POSTGRES_PASSWORD: your_password
    ports:
      - "5432:5432"
    networks:
      - app-network

  tomcat:
    image: tomcat:9.0-jdk8
    container_name: tomcat
    ports:
      - "8080:8080"
    volumes:
      - ./path/to/your/war:/usr/local/tomcat/webapps/yourapp.war
    networks:
      - app-network

networks:
  app-network:
    driver: bridge

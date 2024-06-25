# Use uma imagem base do OpenJDK 17
FROM openjdk:17-jdk-alpine

# Defina o diretório de trabalho no contêiner
WORKDIR /app

# Copie o arquivo JAR da aplicação para o diretório de trabalho do contêiner
COPY build/libs/teste-0.0.1-SNAPSHOT.jar /app/teste.jar

# Exponha a porta que a aplicação Spring Boot usará
EXPOSE 8080

# Defina o comando de inicialização para executar a aplicação
ENTRYPOINT ["java", "-jar", "teste.jar"]

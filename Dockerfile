# Estágio 1: Build (compilação do JAR)
FROM maven:3-eclipse-temurin-25 AS builder

# Define o diretório de trabalho
WORKDIR /app

# Copia o pom.xml e baixa as dependências (cache de layers para builds mais rápidos)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código-fonte e compila o JAR (skip tests para builds mais rápidos; remova se quiser testes)
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio 2: Runtime (imagem final leve)
FROM eclipse-temurin:25-jre-alpine

# Cria um usuário não-root para segurança
RUN addgroup -g 1001 -S spring && \
    adduser -S spring -u 1001

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR compilado do estágio anterior
COPY --from=builder /app/target/simplecrud-0.0.1-SNAPSHOT.jar app.jar

# Muda a propriedade do JAR para o usuário não-root
RUN chown spring:spring /app/app.jar

# Troca para o usuário não-root
USER spring:spring

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando de entrada: executa o JAR com Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
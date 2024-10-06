# Fase de construcción
FROM maven:3.8.4-openjdk-17 AS builder

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos pom.xml y el directorio src
COPY pom.xml .
COPY src ./src

# Construye la aplicación
RUN mvn clean package -DskipTests

# Fase de ejecución
FROM openjdk:17-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR construido desde la fase de construcción
COPY --from=builder /app/target/*.jar app.jar

# Expone el puerto en el que la aplicación escuchará
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
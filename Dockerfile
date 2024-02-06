# Usa una imagen base de OpenJDK para Java 17
FROM openjdk:17

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el JAR de tu aplicación Spring Boot (asegúrate de que se encuentre en el mismo directorio que este Dockerfile)
COPY target/demo-pjgl-0.0.1-SNAPSHOT.jar /app/demo-pjgl.jar

# Expone el puerto en el que tu aplicación Spring Boot está escuchando (el mismo que especificas en tu aplicación)
EXPOSE 8080

#zzz Comando para ejecutar la aplicación Spring Boot al iniciar el contenedor
CMD ["java", "-jar", "/app/demo-pjgl.jar"]

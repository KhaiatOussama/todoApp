#Image personaliser pour le maven et jdk20
FROM maven:3.8.7-jdk-20
#Le dossier de travaille sur Image
WORKDIR /app
#Copier le fichier jar dans le dossier de travaille
COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar
#Installer les dépendances existe dans le fichier pom.xml
RUN mvn clean install
EXPOSE 8080
CMD ["java", "-jar", "/app/demo.jar"]

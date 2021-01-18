FROM maven

# copy the project files
COPY ./pom.xml ./pom.xml
COPY ./src ./src

#RUN mvn dependency:go-offline -B
RUN mvn clean install -Dmaven.test.skip=true

ENTRYPOINT ["java","-jar", "target/complaints-0.0.1-SNAPSHOT.jar"]
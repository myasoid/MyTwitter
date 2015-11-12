#MyTwitter



## Requirements
* [Java Platform (JDK) 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Maven 3.x](http://maven.apache.org/)

## Quick start
1. Set params in ```src/main/resources/application.properties```
```
# DataSource settings: set here your own configurations for the database
# create schema "mytwitter" in mysql
spring.datasource.url = jdbc:mysql://localhost:3306/mytwitter
spring.datasource.username = ???
spring.datasource.password = ???
```

2. `mvn spring-boot:run`
3. Point your browser to [http://localhost:8080/](http://localhost:8080/)

### Technology Stack
* [Tomcat](http://tomcat.apache.org/index.html)
* [Spring boot](http://projects.spring.io/spring-boot/)
* [Spring security](http://kielczewski.eu/2014/12/spring-boot-security-application/)
* [Thymeleaf](http://www.thymeleaf.org/)
* [WebJars](http://www.webjars.org/) (Bootstrap, font-awesome, jquery)
* [Spring Data JPA](http://projects.spring.io/spring-data-jpa/)
* [Validation](http://spring.io/guides/gs/validating-form-input/)
* [My SQL](https://www.mysql.com/)
* [SLF4J](http://www.slf4j.org/)
* [Maven 3.x](http://maven.apache.org/index.html)
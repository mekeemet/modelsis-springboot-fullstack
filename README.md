# Application Backend
Ce repertoire contient la partie backend de l'application  
## Table of Contents
1. [Technologies](#technologies)
2. [Installation](#installation)


## Technologies
***

* [Java 8]
* [Spring Boot 2.5.2 ou supérieur]
* [Spring Rest]
* [Spring Data]
* [JPA]
* [Maven 3.2']
* [Postgres 14]
* [Lombok (no getters and setters)]

### Installation
#### \> Configuration
***
  Configuration.(application.properties)

# Information generales de connexion a la base de donnees postgres
***
```
spring.datasource.url=jdbc:postgresql://localhost:5432/ModelsisTest   //  Nom de la base de donnee
spring.datasource.username=postgres					 //  Utilisateur Postgres	
spring.datasource.password=postgres                                    //  Mot de passe Utilisateur 
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.generate-ddl=true
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

```



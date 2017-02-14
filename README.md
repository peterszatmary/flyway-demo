# flyway-demo

https://travis-ci.org/peterszatmary/flyway-demo.svg?branch=master)](https://travis-ci.org/peterszatmary/flyway-demo)

Flyway migration library with usefull configurations on Spring-boot.

Whats interesting here

SpringBoot with
- Flyway like migration library used cross environments
- Freemarker like template engine on frontend
- Spring data like ORM for data

[Flyway](https://flywaydb.org/) is configured via [flyway-maven-plugin](https://mvnrepository.com/artifact/org
.flywaydb/flyway-maven-plugin) to simply switch between different environments.
In this example we have 3 environments dev, test and preprod. All of them have separate
configurations. So in theory they can have different data structure, different data, different db
 drivers.

More obvious is to have same data structures cross environments but different data. Same like in
this Spring Boot application example.

For more information see [wiki](https://github.com/peterszatmary/flyway-demo/wiki).



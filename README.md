# flyway-demo

[![Build Status](https://travis-ci.org/peterszatmary/flyway-demo.svg?branch=master)](https://travis-ci.org/peterszatmary/flyway-demo)

Flyway migration and database evolving library with useful configurations cross different
environments on Spring-boot.

## Whats interesting here

SpringBoot with
- Flyway like migration library used cross environments (See down)
- [Freemarker template engine on frontend](https://github.com/peterszatmary/flyway-demo/wiki/Freemarker-with-SpringBoot)
- [Spring data like ORM for data](https://github.com/peterszatmary/flyway-demo/wiki/Spring-data-like-ORM-for-data)
- [SpringBoot app configured for different environments](https://github.com/peterszatmary/flyway-demo/wiki/SpringBoot-app-configured-for-different-environments.)

[Flyway](https://flywaydb.org/) is configured via [flyway-maven-plugin](https://mvnrepository.com/artifact/org
.flywaydb/flyway-maven-plugin) to simply switch between different environments.
In this example we have 3 environments dev, test and preprod. All of them have separate
configurations. So in theory they can have different data structure, different data, different db
 drivers.

More obvious is to have same data structures cross environments but different data. Same like in
this Spring Boot application example.


## 1. Migration / evolving with Flyway through different environments

For each environment we create maven profile. Profiles will just set properties for main plugin
build.

In whole solution i am using vagrant-mysql database.Feel free to use your own.

### Main plugin configuration looks like following

```xml
<plugin>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-maven-plugin</artifactId>
    <version>4.0.3</version>
    <configuration>
        <driver>${db.driver}</driver>
        <url>${db.url}</url>
        <user>${db.user}</user>
        <password>${db.password}</password>
        <locations>
            <location>${flyway.location}</location>
        </locations>
    </configuration>
</plugin>

```

### DEV environment profile

```xml
<profile>
    <id>DEV-environment</id>
    <properties>
        <db.driver>com.mysql.jdbc.Driver</db.driver>
        <db.url>jdbc:mysql://33.33.33.1/flywaydemodev</db.url>
        <db.user>root</db.user>
        <db.password>root</db.password>
        <flyway.location>filesystem:src/main/resources/db/migration/dev</flyway.location>
    </properties>
</profile>
```

### How to run the dev migration

```
mvn flyway:migrate -P DEV-environment
```

![test migration run](https://github.com/peterszatmary/just-like-that/blob/master/imgs/flyway-demo/dev-migration-run.png)


After that is database prepared for application run. Database has schema and inserted data.

### How to run app with dev database

For app run you need just change in application.properties following

```
environment=dev
```

After that you can see application with dev database and data in it.

![dev app](https://github.com/peterszatmary/just-like-that/blob/master/imgs/flyway-demo/dev-app.png)



### TEST environment profile

```xml
<profile>
    <id>TEST-environment</id>
    <properties>
        <db.driver>com.mysql.jdbc.Driver</db.driver>
        <db.url>jdbc:mysql://33.33.33.1/flywaydemotest</db.url>
        <db.user>root</db.user>
        <db.password>root</db.password>
        <flyway.location>filesystem:src/main/resources/db/migration/test</flyway.location>
    </properties>
</profile>
```

### How to run the test migration

```
mvn flyway:migrate -P TEST-environment
```

![test migration run](https://github.com/peterszatmary/just-like-that/blob/master/imgs/flyway-demo/test-migration-run.png)


Before this step the database is empty. After that is database prepared for application run.
Database has schema and inserted data.

### How to run app with test database

For app run you need just change in application.properties following

```
environment=test
```

Before this step the database is empty. After that you can see application with test database and
data in it.

![test app](https://github.com/peterszatmary/just-like-that/blob/master/imgs/flyway-demo/test-app.png)




### PREPROD environment profile

```xml
<profile>
    <id>PREPROD-environment</id>
    <properties>
        <db.driver>com.mysql.jdbc.Driver</db.driver>
        <db.url>jdbc:mysql://33.33.33.1/flywaydemopreprod</db.url>
        <db.user>root</db.user>
        <db.password>root</db.password>
        <flyway.location>filesystem:src/main/resources/db/migration/preprod</flyway.location>
    </properties>
</profile>
```

### How to run the preprod migration

```
mvn flyway:migrate -P PREPROD-environment
```

![preprod migration run](https://github.com/peterszatmary/just-like-that/blob/master/imgs/flyway-demo/preprod-migration-run.png)

After that is database prepared for application run. Database has schema and inserted data.

### How to run app with preprod database

For app run you need just change in application.properties following

```
environment=preprod
```


![preprod app](https://github.com/peterszatmary/just-like-that/blob/master/imgs/flyway-demo/preprod-app.png)


### Project structure for flyway multi environment support

![project structure](https://github.com/peterszatmary/just-like-that/blob/master/imgs/flyway-demo/project-structure.png)
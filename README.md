
github link -> https://turgaycan2.github.io/spring-boot-liquibase-example/

## Welcome to spring-boot-liquibase integration example

Spring boot, liquibase integration and h2 db integration test for PostgreSQL 


### Technologies

- spring boot 1.5.1.RELEASE
- spring-boot-starter-parent
- spring-boot-starter-data-jpa
- spring-boot-starter-test
- h2 db
- postgresql
- liquibase

# application-test.properties

```
spring.datasource.name=testData
spring.jmx.default-domain=jpa.sample

management.security.enabled=false
spring.jpa.hibernate.ddl-auto=none

liquibase.change-log=classpath:/db/changelog/db.changelog-master.xml
liquibase.enabled=true
liquibase.url=jdbc:h2:mem:testData;mode:PostgreSQL
liquibase.user=sa
liquibase.password=
```

# liquibase changelog.xml

```
<?xml version="1.0" encoding="UTF-8"?>

<databaseChangeLog
        xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
         http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.1.xsd">

    <changeSet id="2017-02-15 12:00" author="turgay">
        <createTable tableName="city">
            <column name="id" type="long" autoIncrement="true">
                <constraints primaryKey="true" nullable="false"/>
            </column>
            <column name="name" type="varchar(50)">
                <constraints nullable="false"/>
            </column>
            <column name="state" type="varchar(50)">
                <constraints nullable="false"/>
            </column>
            <column name="country" type="varchar(50)">
                <constraints nullable="false"/>
            </column>
            <column name="map" type="varchar(50)">
                <constraints nullable="false"/>
            </column>
        </createTable>
    </changeSet>

</databaseChangeLog>

```

## Part 1st
Firstly downloaded the maven file from spring intializer.
[Link for spring intializr](https://start.spring.io/)

### Custom choices were:
```
Maven + Java
SpringBoot 4.0.6
Jar packaging
Dependencies: Spring web, Lombok, H2 Database, Spring Boot Dev Tools, Spring Data JPA
```

### Database Connection
Connected PostgreSQL
- downloaded postgresql
- updated pom.xml with dependency:
    ```
    <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
     </dependency>
    ```
- Updated the properties file with:
      ```properties
# tells Spring where your database lives
spring.datasource.url=jdbc:postgresql://localhost:5432/oa_platform

# database credentials
spring.datasource.username=oa_user
spring.datasource.password=yourpassword

# update = hibernate auto-creates/updates tables from @Entity classes
spring.jpa.hibernate.ddl-auto=update

# prints every SQL query to console during development
spring.jpa.show-sql=true

# JWT config
jwt.secret=your-secret-key
jwt.expiration=86400000
```

## To check tables in **pgAdmin4**:
```
SELECT table_name FROM information_schema.tables 
WHERE table_schema = 'public';
```



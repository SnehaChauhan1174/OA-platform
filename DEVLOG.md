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
```
// tells Spring where your database lives
spring.datasource.url=jdbc:postgresql://localhost:5432/oa_platform

// database credentials
spring.datasource.username=oa_user
spring.datasource.password=yourpassword

// update = hibernate auto-creates/updates tables from @Entity classes
spring.jpa.hibernate.ddl-auto=update

// prints every SQL query to console during development
spring.jpa.show-sql=true

// JWT config
jwt.secret=your-secret-key
jwt.expiration=86400000
```


### To check tables in **pgAdmin4**:
```
SELECT table_name FROM information_schema.tables 
WHERE table_schema = 'public';
```

### Request Flow
```
HTTP Request (Postman / React)
↓
JwtFilter — validates token on every request
↓
SecurityConfig — checks role permissions
↓
Controller — receives request, calls service
↓
Service — business logic
↓
Repository — DB query via JPA
↓
PostgreSQL — data stored/fetched
↓
Response back to client
```

### 8th june
admin company controller
methods are 
 - add
 - get list of all companies
 - get a company
 - update
 - delete

now see regarding question bank many things gte dicussed
what we are doing now
Phase 1 — Static Bank (Build Now)
This is your foundation. Everything else sits on top.
Step 1: Question entity + TestCase entity
Step 2: QuestionRepository + TestCaseRepository
Step 3: QuestionService (add, tag, list)
Step 4: AdminQuestionController (CRUD)
Step 5: CompanyTopicWeight entity + CRUD
Step 6: Static weighted sampling (pure SQL)
Step 7: Seed 50-100 questions manually + via LLM script

Phase 2 — RAG Layer on Top (After Platform Works)
Step 1: Add pgvector extension to PostgreSQL
in this question bank is like a knowledge system and rag will retrieve from this now the question is how we can work for testcase and other things 


   

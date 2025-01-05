# Spring Boot CRUD Application with GenericCrudService

This project demonstrates a Spring Boot CRUD application for managing `Product` and `Customer` entities using an H2 in-memory database, JPA, and a generic service layer (`GenericCrudService`). The application is designed with reusability and simplicity in mind.

## Features
- CRUD operations for `Product` and `Customer`
- Generic service for reusable CRUD logic
- H2 in-memory database for fast testing and development
- Constructor Dependency Injection for better testability
- RESTful API with endpoints for `Product` and `Customer`

---
## Project Structure

```plaintext
src/main/java/com/example/demo/
├── DemoApplication.java
├── controller/
│   ├── CustomerController.java
│   ├── ProductController.java
├── entity/
│   ├── BaseEntity.java
│   ├── Customer.java
│   ├── Product.java
├── repository/
│   ├── BaseRepository.java
│   ├── CustomerRepository.java
│   ├── ProductRepository.java
├── service/
│   ├── GenericCrudService.java
│   ├── CustomerService.java
│   ├── ProductService.java
└── resources/
    ├── application.properties

```
### Core Components
1. BaseEntity
   BaseEntity is an abstract class that provides common properties for all entities in the project.

```java
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

```
    Purpose:
        Centralizes the id property and its generation strategy to avoid duplication across entities.

    Usage:
        All entity classes (e.g., Product, Customer) extend BaseEntity to inherit the id field.
        
2. BaseRepository
   BaseRepository is a generic repository interface that extends Spring Data JPA’s JpaRepository.

```java
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {
}

```
    Purpose:
        Provides a common base for all repositories, allowing them to share JPA functionality.

    Usage:
        Specific repositories (e.g., ProductRepository, CustomerRepository) extend BaseRepository to inherit standard CRUD methods.

3. GenericCrudService
   GenericCrudService is an abstract service that provides reusable CRUD methods for any entity.
```java
package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericCrudService<T, ID> {
    protected abstract JpaRepository<T, ID> getRepository();

    public T save(T entity) {
        return getRepository().save(entity);
    }

    public Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    public List<T> findAll() {
        return getRepository().findAll();
    }

    public void deleteById(ID id) {
        getRepository().deleteById(id);
    }
}

```

    Purpose:
        Centralizes CRUD logic for services to reduce duplication and increase maintainability.

    Usage:
        Specific services (e.g., ProductService, CustomerService) extend GenericCrudService and provide their respective repositories.

API Endpoints

    Product API
    GET /products: Retrieve all products
    GET /products/{id}: Retrieve a product by ID
    POST /products: Create a new product
    DELETE /products/{id}: Delete a product by ID 
    
    Customer API
    GET /customers: Retrieve all customers
    GET /customers/{id}: Retrieve a customer by ID
    POST /customers: Create a new customer
    DELETE /customers/{id}: Delete a customer by ID
    
## Database Configuration
```properties
# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password

# Enable H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Hibernate Settings
spring.jpa.hibernate.ddl-auto=update

```

Access H2 Console
1. Start the application.
2. Open your browser and navigate to: http://localhost:8080/h2-console
3. Use the following credentials:
   - JDBC URL: jdbc:h2:mem:testdb 
   - Username: sa 
   - Password: password

## Running the Application
1. Clone this repository.
2. Build and run the application:
```bash
mvn spring-boot:run
```
3. Access the APIs using tools like Postman or curl.

## Future Improvements
- Add validation for request data using javax.validation.
- Implement pagination for large datasets.
- Secure the APIs using Spring Security.

## Contact

---
For questions or support, please contact:  
**Nuchit Atjanawat**  
**Email**: nuchit@outlook.com  
**GitHub**: [nuchit2019](https://github.com/nuchit2019)

--- 

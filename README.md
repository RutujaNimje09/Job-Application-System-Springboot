# Job Application System

A Spring Boot REST API project for managing job postings and student job applications using JPA relationships, DTOs, and MySQL.

---

## Features

- Add and view job postings
- Apply for jobs
- View all applications
- Prevent duplicate job applications
- RESTful API architecture
- DTO implementation
- JPA Relationships (`@ManyToOne`)
- MySQL database integration

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Lombok
- Postman

---

## Project Structure

```text
src/main/java/com/example/jobportal
│
├── controller
├── dto
├── entity
├── repository
├── service
└── JobportalApplication.java
```

---

## Database Configuration

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jobportal
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## API Endpoints

### Create Job

```http
POST /jobs
```

Request Body:

```json
{
  "companyName": "TCS",
  "role": "Java Developer",
  "packageAmount": 700000,
  "location": "Pune"
}
```

---

### Get All Jobs

```http
GET /jobs
```

---

### Apply for Job

```http
POST /applications/apply
```

Request Body:

```json
{
  "studentId": 1,
  "jobId": 1
}
```

---

### Get All Applications

```http
GET /applications
```

---

## Relationships Used

- One Student → Many Applications
- One Job → Many Applications

Implemented using:

```java
@ManyToOne
@JoinColumn
```

---

## Bonus Features

- Duplicate application prevention using:
  - `@UniqueConstraint`
  - Custom repository validation

---

## How to Run

### Clone Repository

```bash
git clone YOUR_REPO_LINK
```

### Open Project

Open in:
- STS 4
- IntelliJ IDEA
- VS Code

### Run Application

```bash
mvn spring-boot:run
```

or run:

```text
JobportalApplication.java
```

---

## Author

Rutuja Nimje

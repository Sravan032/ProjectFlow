# ProjectFlow

A full-stack Project & Task Management application built using Spring Boot, React, JWT Authentication, and MySQL.

---

# Features

## Authentication & Security
- JWT Authentication
- Spring Security
- BCrypt Password Hashing
- Role-Based Authorization (ADMIN / USER)
- Protected REST APIs

---

## Project Management
- Create Project
- View Projects
- Update Projects
- Delete Projects

---

## Task Management
- Create Tasks
- Assign Tasks
- Update Task Status
- Delete Tasks
- Priority Management

---

## Frontend Features
- User Registration
- User Login
- Dashboard
- Task & Project Forms
- Role-Based UI Rendering

---

# Tech Stack

## Backend
- Java
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- MySQL

## Frontend
- React
- Axios
- React Router

---

# API Documentation

Swagger UI:
```bash
http://localhost:8080/swagger-ui/index.html
```

---

# Project Structure

## Backend

```bash
src/main/java/com/sravan/ProjectFlow
│
├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── config
├── exception
└── enums
```

---

# Setup Instructions

## Backend Setup

### Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/ProjectFlow.git
```

### Configure MySQL

Update:

```bash
src/main/resources/application.properties
```

### Run Backend

```bash
mvn spring-boot:run
```

---

## Frontend Setup

```bash
cd projectflow-frontend
npm install
npm run dev
```

---

# Authentication Flow

1. User registers
2. User logs in
3. JWT token generated
4. Frontend stores token
5. Protected APIs accessed using Bearer Token

---

# Role-Based Access

## ADMIN
- Manage Projects
- Manage Tasks
- Delete Resources

## USER
- View Projects
- View Tasks

---

# Future Improvements

- Docker Deployment
- Kubernetes Deployment
- Email Notifications
- Task Comments
- File Attachments

---

# Author

Sravan

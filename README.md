# Departments and Employees API (Lab PI 1)

A simple Spring Boot REST API to manage departments and their linked employees.

Developed as part of a lab/project (labpi1).

## Technologies

- Java 21
- Spring Boot (Web, Data JPA)
- PostgreSQL
- Maven

## How to run locally

1. Run PostgreSQL locally (on port `5432`).
2. Create a database named `departamentos`. The user and password in `application.properties` are set to `postgres` / `postgres`.
3. In the project root folder, run:
   ```bash
   ./mvnw spring-boot:run
   ```
*Note: `ddl-auto` is set to `create-drop`, so your data will be wiped and tables recreated every time you restart the application.*

## API Endpoints

The app runs on `http://localhost:8080` by default.

### Departments
- `GET /departamento` - Lists all departments
- `POST /departamento` - Creates a new department
- `GET /departamento/{depId}` - Gets a specific department
- `DELETE /departamento/{depId}` - Deletes a department

### Employees
- `GET /departamento/{depId}/funcionarios` - Lists all employees in a department
- `POST /departamento/{depId}/funcionarios` - Adds a new employee to a department
- `GET /departamento/{depId}/funcionarios/{funcId}` - Gets a specific employee from a department

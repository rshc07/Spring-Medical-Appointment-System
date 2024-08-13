# Medical Appointment System

## Introduction

The Medical Appointment System is a Spring Boot application that allows users to manage medication-related operations,It includes functionalities to create, read, update, and delete Operations on medication data. The project also integrates Swagger (OpenAPI) for interactive API documentation.

## Table of Contents

- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Project Setup](#project-setup)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [API Endpoints](#api-endpoints)

## Technologies Used

- **Java**: Programming language.
- **Spring Boot**: Framework for building Java applications.
- **Spring Data JPA**: For database access and ORM.
- **Thymeleaf**: Template engine for rendering web pages.
- **Swagger (OpenAPI)**: For API documentation.
- **Maven**: Build automation tool.
- **MySQL**: Database.
- **HTML**: Markup language for creating web pages.
- **CSS**: Style sheet language for designing web pages.

## Prerequisites

- Java 8 or higher
- Maven 3.6.0 or higher
- Git (optional)

## Project Setup

1. **Clone the Repository** (if applicable):

    ```sh
    git clone [https://github.com/rshc07/Spring-Medical-Appointment-System.git]
    cd Medical-Appointment-System
    ```

2. **Import the Project into Your IDE**:

    - Open your IDE (e.g., IntelliJ IDEA, Eclipse).
    - Import the project as a Maven project.

3. **Build the Project**:

    ```sh
    mvn clean install
    ```
## Configuration

1. **Application Properties**:

    Open `src/main/resources/application.properties` and configure the database settings as per your environment:

    ```properties
    # Database Configuration
    spring.datasource.url=jdbc:mysql://localhost:3306/hospitalmanagement_db
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=Msdhoni1997*
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

    # Server Configuration
    server.port=8080
    ```

    Ensure you have a MySQL database running with the name `hospitalmanagement_db` and update the username and password accordingly.

## Running the Application

1. **Run the Application**:

    You can run the application using your IDE or via the command line:

    ```sh
    mvn spring-boot:run
    ```

    The application will start on the port configured in `application.properties` (default is 8080).

2. **Access the Application**:

    Open your web browser and navigate to `http://localhost:8080`.

## API Documentation

This project uses Swagger (OpenAPI) for API documentation.

1. **Access Swagger UI**:

    After starting the application, you can access the Swagger UI at:

    ```sh
    http://localhost:8080/swagger-ui.html
    ```

    This provides an interactive interface to test the API endpoints.

## API Endpoints

### DoctorController
- **View all doctors**
  - **Endpoint**: `/displayDoctor`
  - **Method**: `GET`
  - **Description**: Retrieves and displays a list of all doctors.

- **Get booking form for a doctor**
  - **Endpoint**: `/doctorBook/{id}`
  - **Method**: `GET`
  - **Description**: Retrieves the booking form for a specific doctor by ID.

### AppointmentController
- **View the appointment form**
  - **Endpoint**: `/appointmentForm`
  - **Method**: `GET`
  - **Description**: Displays the appointment booking form.

- **Save a new appointment**
  - **Endpoint**: `/appointmentForm`
  - **Method**: `POST`
  - **Description**: Saves a new appointment with the provided details.

- **View all appointments**
  - **Endpoint**: `/displayAppointment`
  - **Method**: `GET`
  - **Description**: Retrieves and displays a list of all appointments.

### LoginController
- **View the login page**
  - **Endpoint**: `/`
  - **Method**: `GET`
  - **Description**: Displays the login page.

- **View the login page**
  - **Endpoint**: `/login`
  - **Method**: `GET`
  - **Description**: Displays the login page.

- **View the registration form**
  - **Endpoint**: `/register`
  - **Method**: `GET`
  - **Description**: Displays the registration form.

- **Register a new user**
  - **Endpoint**: `/register`
  - **Method**: `POST`
  - **Description**: Registers a new user with the provided details.

- **View the home page**
  - **Endpoint**: `/home`
  - **Method**: `GET`
  - **Description**: Displays the home page.

### MedicationController
- **View all medications**
  - **Endpoint**: `/viewMedicine`
  - **Method**: `GET`
  - **Description**: Retrieves and displays a list of all medications.

- **Get the form to add a new medication**
  - **Endpoint**: `/addMedicine`
  - **Method**: `GET`
  - **Description**: Displays the form to add a new medication.

- **Add a new medication**
  - **Endpoint**: `/addMedicine`
  - **Method**: `POST`
  - **Description**: Adds a new medication with the provided details.

- **Get the form to update a medication**
  - **Endpoint**: `/updateMedicine/{Id}`
  - **Method**: `GET`
  - **Description**: Displays the form to update a specific medication by ID.

- **Update a medication**
  - **Endpoint**: `/updateMedicine/{Id}`
  - **Method**: `POST`
  - **Description**: Updates the details of a specific medication by ID.

- **Delete a medication**
  - **Endpoint**: `/deleteMedicine/{Id}`
  - **Method**: `GET`
  - **Description**: Deletes a specific medication by ID.



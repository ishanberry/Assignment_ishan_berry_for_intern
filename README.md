# Markersharks Supplier API Intern Assignment

## Overview

The Markersharks Supplier API provides endpoints to search for manufacturers based on customized requirements. This proof-of-concept API allows users to retrieve a list of suppliers based on location, nature of business, and manufacturing processes.

## Features

- **Search for Suppliers**: Query suppliers by location, nature of business, and manufacturing processes.
- **Pagination**: Handle large results with pagination.
- **Validation**: Input validation is enforced using annotations.
- **Global Exception Handling**: The API includes a global exception handler to manage and respond to errors effectively.
- **Swagger Documentation**: The API documentation is auto-generated and available via Swagger UI.
- **H2 In-Memory Database**: Uses H2 for easy setup and testing.

## Setup

### Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

### Installation

1. **Clone the Repository**

    ```bash
    git clone https://github.com/your-username/your-repository.git
    cd your-repository
    ```

2. **Build the Project**

    ```bash
    mvn clean install
    ```

3. **Run the Application**

    ```bash
    mvn spring-boot:run
    ```

    The application will start on `http://localhost:8080`.

## API Endpoints

### 1. **Query Suppliers**

- **Endpoint**: `/api/supplier/query`
- **Method**: `POST`
- **Description**: Retrieve a list of suppliers based on location, nature of business, and manufacturing processes.
- **Request Body**:

    ```json
    {
      "supplierId": 1,
      "companyName": "Test Company",
      "website": "http://example.com",
      "location": "Test Location",
      "natureOfBusiness": "small_scale",
      "manufacturingProcesses": ["moulding"]
    }
    ```

- **Query Parameters**:
    - `page`: (Optional) Page number for pagination (default is 0).
    - `size`: (Optional) Number of results per page (default is 10).

- **Response**: 

    ```json
    [
      {
        "supplierId": 1,
        "companyName": "Test Company",
        "website": "http://example.com",
        "location": "Test Location",
        "natureOfBusiness": "small_scale",
        "manufacturingProcesses": ["moulding"]
      }
    ]
    ```

### 2. **Exception Handling**

The API includes global exception handling to ensure all errors are managed effectively:

- **Validation Errors**: If the input data does not meet validation criteria, a detailed error message will be returned.
- **General Errors**: Any unexpected errors are caught and returned with a standard error message.

### 3. **Swagger Documentation**

The API documentation is available via Swagger. To view it:

- Open `http://localhost:8080/swagger-ui.html` in your web browser.

### 4. **Pagination**

To handle large datasets, the API supports pagination:

- **Query Parameters**:
    - `page`: Page number (default is `0`).
    - `size`: Number of records per page (default is `10`).

## Security

- **TODO**: Implement security best practices such as authentication and authorization. Ensure sensitive data protection and prevention of common vulnerabilities.

## Database

- **H2 Database**: The application uses an H2 in-memory database for development and testing. This allows for easy setup and testing without requiring a full database installation.

### H2 Console Access

You can access the H2 database console for development and debugging purposes:

- **URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: *(leave empty)*

## Contribution

Feel free to fork the repository and submit pull requests. For any issues or feature requests, please open an issue on GitHub.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

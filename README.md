# Client Microservice - Technical Challenge

This is a microservice developed in Java using Spring Boot. Its purpose is to manage client data through a documented REST API with Swagger. The service is deployed on Google Cloud.

## Description

This microservice allows you to perform basic CRUD operations on a list of clients. The available endpoints are as follows:

- **POST /createclient**: Creates a new client.
- **GET /kpiclients**: Calculates the average age and standard deviation of the ages of all clients.
- **GET /listclients**: Retrieves the list of clients with all their data, and calculates the probable date of death for each client based on their current age.

## Requirements

- Java 17 or later
- Maven 3.9.9 or later
- Spring Boot 3.1.5
- Google Cloud access (for deployment)
- GitHub (for code management)

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/BacinoAilin/microservicio-clientes.git
   cd microservicio-clientes

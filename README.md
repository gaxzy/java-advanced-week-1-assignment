# Game Library API

## Description
Game Library API is a Spring Boot application that provides RESTful endpoints to manage a collection of games. This API allows users to create, read, update, and delete game records from the library.

## How to Run
To run the application, use the Maven wrapper with the Spring Boot plugin:

```bash
./mvnw spring-boot:run
```

## API Endpoints

The application runs on `http://localhost:8080` by default. Here are the available endpoints and how to test them using Postman:

### Get All Games
- **Method**: GET
- **URL**: http://localhost:8080/games
- **Postman**: Create a new GET request with the URL above

### Get Game by ID
- **Method**: GET
- **URL**: http://localhost:8080/games/{id}
- **Postman**: Create a new GET request with the URL, replacing {id} with the actual game ID (e.g., http://localhost:8080/games/1)

### Add New Game
- **Method**: POST
- **URL**: http://localhost:8080/games
- **Headers**: Content-Type: application/json
- **Body**: Raw JSON
```json
{
  "title": "Example Game",
  "developer": "Example Developer",
  "releaseYear": 2023,
  "genre": "Action"
}
```
- **Postman**: Create a new POST request, add the header, select Body > raw > JSON, and paste the JSON data

### Update Game
- **Method**: PUT
- **URL**: http://localhost:8080/games/{id}
- **Headers**: Content-Type: application/json
- **Body**: Raw JSON
```json
{
  "title": "Updated Game",
  "developer": "Updated Developer",
  "releaseYear": 2024,
  "genre": "Adventure"
}
```
- **Postman**: Create a new PUT request, add the header, select Body > raw > JSON, and paste the JSON data

### Delete Game
- **Method**: DELETE
- **URL**: http://localhost:8080/games/{id}
- **Postman**: Create a new DELETE request with the URL, replacing {id} with the actual game ID (e.g., http://localhost:8080/games/1)

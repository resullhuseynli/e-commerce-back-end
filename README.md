# E-Commerce Application

This is a Spring Boot-based e-commerce application that allows users to manage categories, products, and orders. The application uses Java, Spring Boot, and Maven for development. This is the first Spring Boot Application I made.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [DTOs](#dtos)
- [Services](#services)
- [Repositories](#repositories)
- [Models](#models)
- [Contributing](#contributing)
- [License](#license)

## Features

- Manage product categories
- Manage products
- Create and manage orders
- Calculate total order price
- Handle product stock levels

## Technologies Used

- Java
- Spring Boot
- Maven
- JPA/Hibernate
- Lombok

## Project Structure

The project follows a standard Spring Boot structure:

src/ ├── main/ │ ├── java/ │ │ └── com/ │ │ └── MyProject/ │ │ └── e_commerce/ │ │ ├── Controller/ │ │ ├── Model/ │ │ ├── Repository/ │ │ ├── Service/ │ │ └── dto/ │ └── resources/ │ └── application.properties └── test/

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/resulhuseynlii/e_commerce.git
    cd e_commerce
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn spring-boot:run
    ```

## API Endpoints

### Category Endpoints

- `GET /category/get/all-list` - Get all categories
- `GET /category/get/{id}` - Get category by ID
- `POST /category/post/new` - Add a new category
- `PUT /category/update/{id}` - Update a category
- `DELETE /category/delete/{id}` - Delete a category

### Product Endpoints

- `GET /products/get/all-list` - Get all products
- `GET /products/get/{id}` - Get product by ID
- `POST /products/add/new` - Add a new product
- `PUT /products/update/{id}` - Update a product
- `DELETE /products/delete/{id}` - Delete a product
- `POST /products/add/{id}` - Add quantity to a product

### Order Endpoints

- `POST /order/buy` - Create a new order
- `GET /order/get/{id}` - Get order by ID
- `GET /order/get/all-orders` - Get all orders
- `DELETE /order/delete/{id}` - Delete an order

## DTOs

### Request DTOs

- `dtoCategoriesRequest` - Request DTO for categories
- `dtoOrdersRequest` - Request DTO for orders
- `dtoProductsRequest` - Request DTO for products

### Response DTOs

- `dtoCategoriesResponse` - Response DTO for categories
- `dtoOrdersResponse` - Response DTO for orders
- `dtoProductsResponse` - Response DTO for products

## Services

### CategoriesService

Handles business logic for categories, including adding, updating, deleting, and retrieving categories.

### OrderService

Handles business logic for orders, including creating, updating, deleting, and retrieving orders.

## Repositories

### CategoriesRepository

Extends `JpaRepository` to provide CRUD operations for `Categories`.

### OrderProductsRepository

Extends `JpaRepository` to provide CRUD operations for `OrderProducts` and custom queries.

### OrdersRepository

Extends `JpaRepository` to provide CRUD operations for `Orders` and custom queries.

### ProductsRepository

Extends `JpaRepository` to provide CRUD operations for `Products` and custom queries.

## Models

### Categories

Represents a product category.

### OrderProducts

Represents the relationship between orders and products.

### Orders

Represents an order.

### Products

Represents a product.

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

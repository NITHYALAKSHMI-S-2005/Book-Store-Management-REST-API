📚 Book Store Management REST API

A Spring Boot RESTful API for managing a Book Store.
It supports CRUD operations for Books and Customers, as well as Order Placement & Order History, with database integration and validation.

🚀 Features

📖 Books Management – Add, update, delete, and view books.

👤 Customers Management – Register, update, delete, and view customers.

🛒 Order Management – Place orders, update stock automatically, and retrieve order history.

✅ Validation – Input validation using Jakarta Validation (JSR-380).

💾 Database Integration – Works with H2 (in-memory) or MySQL.

⚡ Exception Handling – Global error handler for clean API responses.

🛠️ Tech Stack

Java 17+

Spring Boot 3.2

Spring Data JPA (Hibernate)

H2 Database (default) / MySQL

Jakarta Validation

Lombok

Run the application:

mvn spring-boot:run

Access the app:

API base URL: http://localhost:8080/api/

H2 Console: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:bookstoredb)

🔗 API Endpoints
📚 Books

GET /api/books → Get all books

GET /api/books/{id} → Get book by ID

POST /api/books → Add new book

PUT /api/books/{id} → Update book

DELETE /api/books/{id} → Delete book

👤 Customers

GET /api/customers → Get all customers

GET /api/customers/{id} → Get customer by ID

POST /api/customers → Register new customer

PUT /api/customers/{id} → Update customer

DELETE /api/customers/{id} → Delete customer

🛒 Orders

POST /api/orders/place?customerId=1&bookId=2&quantity=3 → Place order

GET /api/orders → Get all orders

✅ Example JSON Requests

Create Book

{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "price": 450.0,
  "stock": 10
}


Create Customer

{
  "name": "Alice Johnson",
  "email": "alice@example.com"
}

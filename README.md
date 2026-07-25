# E-Commerce Management System

A full-stack **E-Commerce Management System** built using **Java, JSP, Servlets, JDBC, and MySQL**. The application provides a complete online shopping platform where **Buyers**, **Sellers**, and **Administrators** can efficiently manage products, orders, and users through dedicated dashboards.

---

## Overview

The E-Commerce Management System is designed to simulate a real-world online marketplace. It allows sellers to manage product listings, buyers to browse and purchase products, and administrators to oversee the entire platform.

This project demonstrates the implementation of the **MVC Architecture**, database connectivity using **JDBC**, and server-side web development using **Java Servlets and JSP**.

---

## Features

### 👨‍💼 Administrator
- Manage users
- Add, edit and delete products
- Approve product listings
- Manage orders
- Monitor platform activity
- View system statistics

### 🛍️ Seller
- Add new products
- Update product information
- Delete products
- Manage inventory
- Process customer orders
- Track sales performance

### 👤 Buyer
- User Registration & Login
- Browse available products
- Search and filter products
- Add products to cart
- Place orders
- View order history
- Manage profile information

---

## Tech Stack

| Technology | Purpose |
|------------|---------|
| Java | Backend Logic |
| JSP | Frontend Views |
| Servlets | Controller Layer |
| JDBC | Database Connectivity |
| MySQL | Database |
| HTML5 | Structure |
| CSS3 | Styling |
| JSTL | Dynamic Web Pages |
| Apache Tomcat | Application Server |
| Maven | Dependency Management |

---

## Project Structure

```
E-Commerce-Management-System
│
├── EcommerceSystem
│   ├── src
│   │   ├── controller
│   │   ├── dao
│   │   ├── model
│   │   ├── utility
│   │   └── servlet
│   │
│   ├── WebContent / webapp
│   │   ├── css
│   │   ├── images
│   │   ├── js
│   │   └── jsp
│   │
│   ├── database
│   └── pom.xml
│
└── README.md
```

> Folder names may vary slightly depending on your IDE or project structure.

---

## Installation

### Prerequisites

- Java JDK 17 (or compatible version)
- Apache Tomcat
- MySQL Server
- Maven
- Eclipse / IntelliJ IDEA / NetBeans

---

### Setup

1. Clone the repository

```bash
git clone https://github.com/tanupriyasingh07/Online-E-Commerce-Management-System.git
```

2. Import the project into your IDE.

3. Create a MySQL database.

4. Import the SQL file into MySQL.

5. Update database credentials in the JDBC connection file.

6. Build the project using Maven.

7. Deploy the project on Apache Tomcat.

8. Open the application in your browser.

---

## Database

The project uses **MySQL** for data storage.

Typical database modules include:

- Users
- Products
- Categories
- Orders
- Order Details
- Cart
- Seller Information

---

## Workflow

```
Buyer
   │
   ▼
JSP Pages
   │
   ▼
Servlet Controller
   │
   ▼
Business Logic
   │
   ▼
JDBC
   │
   ▼
MySQL Database
```

---

## Future Improvements

- Payment Gateway Integration
- Email Verification
- OTP Authentication
- Product Reviews & Ratings
- Wishlist
- AI Product Recommendation
- Order Tracking
- REST API Support
- Spring Boot Migration
- Docker Deployment

---

## Learning Outcomes

This project helped in understanding:

- Object-Oriented Programming
- MVC Architecture
- Java Servlets
- JSP
- JDBC
- MySQL Database Design
- Session Management
- CRUD Operations
- Authentication & Authorization

---

## Author

**Tanupriya Singh**
B.Tech CSE (Artificial Intelligence)
Galgotias University

GitHub:
https://github.com/tanupriyasingh07

---

## ⭐ If you found this project helpful, consider giving it a Star!

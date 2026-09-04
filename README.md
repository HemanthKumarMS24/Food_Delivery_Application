# 🍔 Food Delivery Application

A full-stack Java Web Application for online food ordering and delivery management built with **Java Servlets**, **JSP**, **JDBC**, and **MySQL**.

---

## 📌 Features

### 👤 User Management
- **User Registration & Login**: Secure user sign-up and authentication using jBCrypt for password hashing.
- **Session Handling**: Maintains user login session across browsing, cart operations, and checkout.

### 🏪 Restaurant & Menu Browsing
- **Restaurant Listing**: Browse available restaurants along with cuisine types, location, delivery times, and ratings.
- **Dynamic Menu Display**: View detailed menu items per restaurant, including item descriptions, pricing, and images.
- **Image Servlets**: Serve dynamic images for restaurants and menu items directly from the database/storage.

### 🛒 Shopping Cart
- **Interactive Cart**: Add menu items, update item quantities, and remove items.
- **Session-Based Cart**: Retains selected items while navigating between pages.

### 💳 Checkout & Order Processing
- **Checkout Management**: Enter delivery address and select payment modes (Cash on Delivery, UPI, Cards).
- **Order Placement**: Automatically calculates grand total, creates orders, and generates detailed order item records.
- **Order Confirmation**: Instant receipt page with order status updates.

---

## 🛠️ Tech Stack

- **Backend**: Java EE / Jakarta Servlets, JDBC
- **Frontend**: JSP (JavaServer Pages), HTML5, CSS3
- **Database**: MySQL
- **Security**: jBCrypt (Password Hashing)
- **Database Driver**: mysql-connector-j-9.2.0.jar
- **Server**: Apache Tomcat 10+
- **IDE / Build**: Eclipse / Apache Maven / Ant Compatible

---

## 📁 Project Structure

```
Food_Delivery_Application/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       ├── user/              # User Model, DAO, Implementation
│       │       ├── restaurant/        # Restaurant Model & Logic
│       │       ├── menu/              # Menu Model & Logic
│       │       ├── cart/              # Cart Model & Servlets
│       │       ├── order/             # Order & Order Item DAOs
│       │       ├── checkout/          # Order Processing Servlet
│       │       ├── feaching/          # Restaurant & Image Servlets
│       │       └── menufeching/       # Menu Fetching Servlets
│       └── webapp/
│           ├── WEB-INF/
│           │   ├── lib/               # Dependencies (jBCrypt, MySQL Connector)
│           │   └── web.xml            # Deployment Descriptor
│           ├── login.html             # Login Page
│           ├── register.html          # Registration Page
│           ├── reastaurant.jsp        # Restaurant Listing Page
│           ├── menu.jsp               # Menu Page
│           ├── cart.jsp               # Shopping Cart Page
│           ├── checkout.jsp           # Checkout Page
│           └── orderconfirmation.jsp  # Order Confirmation Page
├── .gitignore
└── README.md
```

---

## 🚀 Getting Started

### 📋 Prerequisites

- **Java Development Kit (JDK)**: 17 or higher
- **Apache Tomcat**: Version 10 or higher
- **MySQL Database Server**: Version 8.0 or higher
- **IDE**: Eclipse IDE for Enterprise Java Developers or IntelliJ IDEA

---

### ⚙️ Database Setup

1. Open MySQL Workbench or MySQL CLI and create the required database:
   ```sql
   CREATE DATABASE users;
   USE users;
   ```
2. Create the necessary tables (user, estaurant, menu, orders, order_items).
3. Update database credentials in JDBC implementation classes (UserImplementation.java, etc.):
   ```java
   static String URL = "jdbc:mysql://localhost:3306/users";
   static String USERNAME = "root";
   static String PASSWORD = "YOUR_MYSQL_PASSWORD";
   ```

---

### 💻 Running the Application

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/HemanthKumarMS24/Food_Delivery_Application.git
   ```
2. **Import into IDE**:
   - Open Eclipse IDE / IntelliJ IDEA.
   - Import as an existing Java Web Project.
3. **Deploy to Tomcat**:
   - Add the project to your Apache Tomcat Server configuration.
   - Start the Apache Tomcat server.
4. **Access the App**:
   - Open your browser and navigate to:
     http://localhost:8080/Food_Delivery_Application/

---

## 📄 License

This project is open-source and available for learning and developmental purposes.
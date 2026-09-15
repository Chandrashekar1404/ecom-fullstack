# 🛍️ MegaVault — AI-Powered Full-Stack E-Commerce Platform

<p align="center">
  <strong>A modern e-commerce application built with React + Spring Boot + MySQL, featuring authentication, product discovery, cart & wishlist management, coupons, checkout, Razorpay Test Mode payments, email notifications, and an AI-style shopping assistant.</strong>
</p>

<p align="center">
  <a href="https://github.com/Chandrashekar1404/ecom-fullstack">Repository</a> •
  <a href="#-features">Features</a> •
  <a href="#-installation--setup">Setup</a> •
  <a href="#-api-reference">API Reference</a> •
  <a href="#-testing-checklist">Testing</a>
</p>

---

## 📌 Table of Contents

1. [Project Overview](#-project-overview)
2. [Why MegaVault?](#-why-megavault)
3. [Features](#-features)
4. [Technology Stack](#-technology-stack)
5. [Architecture](#-architecture)
6. [Project Structure](#-project-structure)
7. [Prerequisites](#-prerequisites)
8. [Installation & Setup](#-installation--setup)
9. [Environment Variables & Secrets](#-environment-variables--secrets)
10. [Database Setup](#-database-setup)
11. [Running the Application](#-running-the-application)
12. [Application Flow](#-application-flow)
13. [Authentication Flow](#-authentication-flow)
14. [Product & Search Flow](#-product--search-flow)
15. [Cart & Wishlist Flow](#-cart--wishlist-flow)
16. [Checkout & Coupon Flow](#-checkout--coupon-flow)
17. [Razorpay Test Payment Flow](#-razorpay-test-payment-flow)
18. [AI Assistant](#-ai-assistant)
19. [Email Notifications](#-email-notifications)
20. [REST API Reference](#-api-reference)
21. [Frontend Routes](#-frontend-routes)
22. [Testing Checklist](#-testing-checklist)
23. [Build & Production Preparation](#-build--production-preparation)
24. [Known Limitations](#-known-limitations)
25. [Future Enhancements](#-future-enhancements)
26. [Documentation](#-documentation)
27. [Author](#-author)
28. [License](#-license)

---

## 🚀 Project Overview

**MegaVault** is a full-stack e-commerce project designed to demonstrate how a modern online shopping platform can be built from the ground up using a React frontend, a Spring Boot REST API backend, and a MySQL database.

The application covers the major parts of an e-commerce journey:

```text
User Registration / Login
          ↓
      Home Page
          ↓
 Browse / Search Products
          ↓
 Product Details
          ↓
 Add to Cart / Wishlist
          ↓
     Apply Coupon
          ↓
       Checkout
          ↓
 Payment / COD
          ↓
    Order Placement
          ↓
 Profile / Order History
```

The project also includes an administrative dashboard, an AI-style shopping assistant, email notification endpoints, and Razorpay Test Mode integration.

The current repository is hosted at:

**https://github.com/Chandrashekar1404/ecom-fullstack**

---

## 💡 Why MegaVault?

MegaVault is more than a product listing UI. It demonstrates how the frontend, backend, database, authentication, payments, and supporting services can work together in one application.

It is particularly useful as a learning and portfolio project because it covers:

- React component-based development
- React Router navigation
- Context API based state management
- REST API development with Spring Boot
- JPA/Hibernate database access
- MySQL persistence
- Spring Security and JWT-based authentication
- OTP-based email verification
- Coupon/discount processing
- Razorpay payment order creation and signature verification
- Email notification APIs
- Admin-oriented product and order management

---

## ✨ Features

### 🛒 Customer E-Commerce Features

- User registration
- Email OTP verification
- User login
- JWT-based authentication
- Product listing
- Product detail pages
- Category filtering
- Product search
- Product sorting/filtering
- Shopping cart
- Wishlist
- Coupon application
- Checkout page
- Multiple payment options
- Cash on Delivery flow
- Razorpay Test Mode payment flow
- Profile page
- Order history
- Responsive interface
- Theme support

### 🤖 AI / Smart Shopping Features

- AI assistant page and modal
- Product recommendation endpoint
- Product matching based on shopping-related queries
- Budget-oriented recommendation logic
- Suggested products returned by the backend AI controller

> **Important:** the current implementation is a rule-based/product-scoring assistant rather than a fully external LLM-powered Grok API integration. The backend AI controller scores products based on the user's query and catalog data.

### 👨‍💼 Admin Features

- Admin dashboard
- Product management
- Product creation
- Product update
- Product deletion
- Product restoration helper
- Order overview
- Order status update support
- System user listing endpoint

### 💳 Payment Features

- Razorpay Test Mode order creation
- Server-side Razorpay order creation
- Razorpay checkout integration
- Server-side signature verification endpoint
- UPI-oriented checkout UI
- Card / NetBanking entry point
- COD option

### 📧 Email Features

The backend includes endpoints for:

- Order confirmation emails
- Order cancellation emails

---

## 🧰 Technology Stack

### Frontend

- **React 18**
- **Vite**
- **JavaScript / JSX**
- **React Router DOM**
- **Axios**
- **Bootstrap 5**
- **Bootstrap Icons**
- **React Hot Toast**
- **Swiper**
- **AOS (Animate On Scroll)**

The frontend dependency configuration can be found in `megavault-frontend/package.json`.

### Backend

- **Java 17 target**
- **Spring Boot 3.2.3**
- **Spring Web**
- **Spring Data JPA**
- **Spring Security**
- **Spring Boot Mail**
- **Hibernate**
- **Lombok**
- **JWT (`io.jsonwebtoken`)**
- **MySQL Connector/J**
- **Razorpay Java SDK 1.4.8**
- **Maven**

### Database

- **MySQL 8.x**
- **JPA / Hibernate ORM**

### Tools

- Git
- GitHub
- VS Code / IntelliJ IDEA / Eclipse-compatible Java tooling
- Postman or any REST client for API testing

---

## 🏗️ Architecture

MegaVault follows a typical three-tier full-stack structure:

```text
┌──────────────────────────────┐
│        React Frontend        │
│        localhost:3000        │
│                              │
│ Pages • Components • Context │
│ Services • Routes • UI State │
└──────────────┬───────────────┘
               │ HTTP / REST
               ▼
┌──────────────────────────────┐
│      Spring Boot Backend     │
│        localhost:8080        │
│                              │
│ Controllers → Services       │
│           → Repositories     │
└──────────────┬───────────────┘
               │ JPA / JDBC
               ▼
┌──────────────────────────────┐
│          MySQL 8             │
│       megavault_db           │
└──────────────────────────────┘

External Services
────────────────────────────────
Razorpay Test API
Gmail SMTP / Email Delivery
```

### Backend flow

```text
HTTP Request
    ↓
Controller
    ↓
Service
    ↓
Repository
    ↓
MySQL
    ↓
JSON Response
```

---

## 📂 Project Structure

```text
 ecom-fullstack/
 │
 ├── megavault-backend/
 │   ├── src/
 │   │   ├── main/
 │   │   │   ├── java/
 │   │   │   │   ├── controller/
 │   │   │   │   │   ├── AIController.java
 │   │   │   │   │   ├── AuthController.java
 │   │   │   │   │   ├── CategoryController.java
 │   │   │   │   │   ├── OrderController.java
 │   │   │   │   │   ├── OrderEmailController.java
 │   │   │   │   │   ├── PaymentController.java
 │   │   │   │   │   └── ProductController.java
 │   │   │   │   ├── dto/
 │   │   │   │   ├── entity/
 │   │   │   │   ├── repository/
 │   │   │   │   ├── service/
 │   │   │   │   └── utils/
 │   │   │   └── resources/
 │   │   │       └── application.properties
 │   │   └── test/
 │   │
 │   ├── pom.xml
 │   └── mvnw / mvnw.cmd (when present)
 │
 ├── megavault-frontend/
 │   ├── public/
 │   ├── src/
 │   │   ├── components/
 │   │   ├── context/
 │   │   ├── pages/
 │   │   ├── services/
 │   │   ├── utils/
 │   │   └── main.jsx
 │   ├── package.json
 │   └── package-lock.json
 │
 ├── MegaVault_documentation.pdf
 ├── MegaVault_ppt.pptx
 ├── README.md
 └── .gitignore
```

### Important frontend areas

| Folder | Responsibility |
|---|---|
| `components/` | Reusable UI components such as navbar, cart, product cards, payment modal, AI assistant and common UI |
| `pages/` | Page-level screens such as Home, Products, Checkout, Profile, Wishlist and Admin Dashboard |
| `context/` | Shared client-side state such as authentication, cart, wishlist, orders and theme |
| `services/` | Helper logic for backend/coupon/AI related operations |
| `utils/` | Utility data and helper modules |

### Important backend areas

| Folder | Responsibility |
|---|---|
| `controller/` | REST API endpoints |
| `service/` | Business logic |
| `repository/` | JPA database access |
| `entity/` | Database entities |
| `dto/` | Request / response data transfer objects |
| `utils/` | Shared helpers such as email service utilities |

---

## ✅ Prerequisites

Install the following before starting the project:

| Requirement | Recommended |
|---|---|
| Java | 17+ |
| Spring Boot | 3.2.3 (managed by Maven) |
| Maven | 3.9+ |
| Node.js | 18+ |
| npm | 9+ |
| MySQL | 8.x |
| Git | Latest stable |
| Browser | Chrome / Edge / Firefox |

Verify installations:

```powershell
java -version
mvn -version
node -v
npm -v
git --version
mysql --version
```

---

# ⚙️ Installation & Setup

## Step 1 — Clone the repository

```bash
git clone https://github.com/Chandrashekar1404/ecom-fullstack.git
```

Move into the project:

```bash
cd ecom-fullstack
```

---

## Step 2 — Verify the project folders

You should see:

```text
megavault-backend
megavault-frontend
README.md
.gitignore
```

---

## Step 3 — Start MySQL

Make sure the MySQL service is running.

On Windows PowerShell, you can check:

```powershell
Get-Service MySQL80
```

Start it when required:

```powershell
Start-Service MySQL80
```

> The exact service name can differ on your machine.

---

## Step 4 — Create/configure database access

The backend is configured to connect to:

```text
MySQL host: localhost
MySQL port: 3306
Database: megavault_db
```

The JDBC URL is configured with `createDatabaseIfNotExist=true`, so the database can be created automatically when the MySQL credentials are valid.

The application also uses:

```properties
spring.jpa.hibernate.ddl-auto=update
```

which allows Hibernate to update the schema from the entity mappings.

---

## Step 5 — Configure backend secrets

The application expects environment variables for sensitive configuration.

At minimum, configure:

```text
DB_PASSWORD
RAZORPAY_KEY_ID
RAZORPAY_KEY_SECRET
```

The backend maps these environment variables in `application.properties`.

Example PowerShell session:

```powershell
$env:DB_PASSWORD="your_mysql_password"
$env:RAZORPAY_KEY_ID="rzp_test_your_key_id"
$env:RAZORPAY_KEY_SECRET="your_razorpay_test_secret"
```

Do **not** commit real passwords, Razorpay secrets, JWT secrets, Gmail app passwords, or any other credentials to GitHub.

---

## Step 6 — Configure email delivery

The project includes Spring Mail configuration for Gmail SMTP.

For a local development environment, keep the email username and app password outside source control. A safer production arrangement is to map them from environment variables and keep them out of `application.properties`.

Example concept:

```text
MAIL_USERNAME=your_email@example.com
MAIL_PASSWORD=your_gmail_app_password
```

> Gmail app passwords are sensitive credentials. Never publish them in the repository.

---

## Step 7 — Build the Spring Boot backend

Open a terminal in the backend directory:

```powershell
cd megavault-backend
```

Build the project:

```powershell
mvn clean package
```

For a faster compilation check:

```powershell
mvn clean compile
```

---

## Step 8 — Run the backend

From `megavault-backend`:

```powershell
mvn spring-boot:run
```

The backend runs on:

```text
http://localhost:8080
```

### Example API check

```text
GET http://localhost:8080/api/products
```

A successful response should return a JSON array of products.

---

## Step 9 — Install frontend dependencies

Open a second terminal at the project root:

```powershell
cd megavault-frontend
npm install
```

---

## Step 10 — Start the frontend

```powershell
npm run dev
```

The configured development environment is expected to run on:

```text
http://localhost:3000
```

Open that URL in your browser.

---

## Step 11 — Build the frontend

To create a production build:

```powershell
npm run build
```

To preview the production build locally:

```powershell
npm run preview
```

---

# 🔐 Environment Variables & Secrets

The repository intentionally ignores `.env` files.

Recommended pattern:

### Backend

```text
DB_PASSWORD=...
RAZORPAY_KEY_ID=...
RAZORPAY_KEY_SECRET=...
MAIL_USERNAME=...
MAIL_PASSWORD=...
JWT_SECRET=...
```

### Frontend

When frontend environment variables are needed with Vite, use the `VITE_` prefix, for example:

```text
VITE_API_BASE_URL=http://localhost:8080
```

### Security rules

Never commit:

```text
.env
.env.*
*.pem
*.key
passwords
API secrets
payment secrets
Gmail app passwords
JWT signing secrets
```

This repository also ignores generated Java/Maven and IDE files such as `target/`, `.vscode/`, `.classpath`, `.project`, and `.settings/`.

---

# 🗄️ Database Setup

The backend uses MySQL with JPA/Hibernate.

The main database is:

```text
megavault_db
```

Hibernate maps the Java entities into database tables. The project contains entities for concepts such as:

- Users
- Products
- Categories
- Orders
- Order Items

A typical development sequence is:

```text
Start MySQL
    ↓
Start Spring Boot
    ↓
JPA/Hibernate connects
    ↓
Database/schema is updated
    ↓
APIs become available
```

For a fresh machine, confirm that the MySQL username/password used by the backend is correct before debugging application-level API errors.

---

# ▶️ Running the Application

You need **two terminals**.

### Terminal 1 — Backend

```powershell
cd ecom-fullstack\megavault-backend
mvn spring-boot:run
```

### Terminal 2 — Frontend

```powershell
cd ecom-fullstack\megavault-frontend
npm install
npm run dev
```

Then open:

```text
http://localhost:3000
```

### Local architecture

```text
Browser
  │
  ├── http://localhost:3000  → React / Vite
  │
  └── http://localhost:8080  → Spring Boot REST API
                                  │
                                  └── MySQL :3306
```

---

# 🔄 Application Flow

## 1. New User

```text
Register
  ↓
Registration API
  ↓
OTP email
  ↓
Verify OTP
  ↓
Account verified
  ↓
Login
  ↓
JWT token
```

The authentication controller exposes registration, OTP verification, OTP resend and login endpoints. fileciteturn135file0

## 2. Shopping

```text
Login
 ↓
Browse products
 ↓
Search / Filter
 ↓
Open product details
 ↓
Add to cart
 ↓
Wishlist when required
```

## 3. Checkout

```text
Cart
 ↓
Checkout
 ↓
Shipping details
 ↓
Coupon
 ↓
Payment method
 ├── Razorpay
 └── COD
 ↓
Order placement
 ↓
Profile / Orders
```

---

# 👤 Authentication Flow

The backend exposes these authentication endpoints:

| Method | Endpoint | Purpose |
|---|---|---|
| `GET` | `/api/auth/system-users` | Get system users |
| `POST` | `/api/auth/register` | Register a user |
| `POST` | `/api/auth/verify-otp` | Verify email OTP |
| `POST` | `/api/auth/resend-otp?email=...` | Resend OTP |
| `POST` | `/api/auth/login` | Login |

These routes are implemented by `AuthController`. fileciteturn135file0

---

# 📦 Product & Search Flow

The backend product controller provides:

| Method | Endpoint | Purpose |
|---|---|---|
| `GET` | `/api/products` | Get all products |
| `GET` | `/api/products/{id}` | Get product by ID |
| `GET` | `/api/products/category/{category}` | Get products by category |
| `GET` | `/api/products/search?q=...` | Search products |
| `POST` | `/api/products` | Create product |
| `PUT` | `/api/products/{id}` | Update product |
| `DELETE` | `/api/products/{id}` | Delete product |
| `GET/POST` | `/api/products/restore` | Restore products |

The route mappings are defined in `ProductController`. fileciteturn136file0

Example:

```text
GET http://localhost:8080/api/products/search?q=headphones
```

---

# 🗂️ Category Flow

Category endpoints:

| Method | Endpoint | Purpose |
|---|---|---|
| `GET` | `/api/categories` | Get all categories |
| `GET` | `/api/categories/{catId}` | Get category by category ID |

These mappings are defined in `CategoryController`. fileciteturn137file0

---

# 🛒 Cart & Wishlist Flow

The frontend uses React state/context to manage shopping interactions.

Typical client-side flow:

```text
Product Card
   ↓
Add to Cart
   ↓
Cart Context
   ↓
Cart Page
   ↓
Checkout
```

Wishlist follows a similar pattern:

```text
Product
  ↓
Add to Wishlist
  ↓
Wishlist Context
  ↓
Wishlist Page
```

---

# 🎟️ Checkout & Coupon Flow

The checkout page calculates:

```text
Base Subtotal
   ↓
Coupon Discount
   ↓
Net Subtotal
   ↓
Shipping
   ↓
GST (18%)
   ↓
Grand Total
```

The checkout implementation includes backend coupon helper integration and supports multiple payment methods. The checkout component also passes customer form data into the Razorpay payment modal so the gateway can prefill customer information.

---

# 💳 Razorpay Test Payment Flow

MegaVault currently integrates Razorpay in **Test Mode**.

### High-level flow

```text
Checkout
   ↓
Create Razorpay Order
   ↓
Spring Boot PaymentController
   ↓
Razorpay Test API
   ↓
Real Razorpay Test Order ID
   ↓
Razorpay Checkout UI
   ↓
Payment response
   ↓
Server-side signature verification
   ↓
Successful payment flow
```

The backend payment controller creates the Razorpay order using the Razorpay Java SDK and returns the order ID, amount, currency, receipt and public key ID. fileciteturn132file0

The controller also exposes a signature verification endpoint using Razorpay's verification utility and the server-side secret. fileciteturn132file0

### Payment endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| `POST` | `/api/payment/razorpay/create-order` | Create Razorpay order |
| `POST` | `/api/payment/razorpay/verify-signature` | Verify payment signature |

### Test mode

For development, use Razorpay's **Test Mode** keys. Do not use production credentials while testing.

### Important security note

The public Razorpay key ID can be sent to the frontend. The Razorpay secret must remain on the backend only.

### Important implementation note

A visible QR code or payment popup by itself is **not** sufficient proof that money was received. The application should only consider a payment successful after the trusted payment result has been verified server-side.

---

# 🤖 AI Assistant

The backend exposes an AI-style product assistant under `/api/ai`.

### Chat endpoint

```text
POST /api/ai/chat
```

Example request:

```json
{
  "message": "show me cheap headphones"
}
```

The controller loads products, calculates a match score, sorts recommendations and returns the top three recommendations together with a text response. fileciteturn139file0

### Recommendation endpoint

```text
GET /api/ai/recommendations
```

This returns a limited list of recommended products from the catalog. fileciteturn139file0

---

# 📧 Email Notifications

The backend exposes order email endpoints:

| Method | Endpoint | Purpose |
|---|---|---|
| `POST` | `/api/email/order-confirmation` | Send order confirmation |
| `POST` | `/api/email/order-cancellation` | Send cancellation email |

These routes are implemented in `OrderEmailController`. fileciteturn145file0

Example confirmation payload shape:

```json
{
  "email": "customer@example.com",
  "name": "Customer",
  "orderId": "ORD-100001",
  "totalAmount": 2499,
  "paymentMethod": "Razorpay UPI",
  "upiId": "customer@upi"
}
```

---

# 📑 API Reference

## Authentication

```text
GET    /api/auth/system-users
POST   /api/auth/register
POST   /api/auth/verify-otp
POST   /api/auth/resend-otp?email={email}
POST   /api/auth/login
```

## Products

```text
GET    /api/products
GET    /api/products/{id}
GET    /api/products/category/{category}
GET    /api/products/search?q={query}
POST   /api/products
PUT    /api/products/{id}
DELETE /api/products/{id}
GET    /api/products/restore
POST   /api/products/restore
```

## Categories

```text
GET    /api/categories
GET    /api/categories/{catId}
```

## Orders

```text
POST   /api/orders
GET    /api/orders
GET    /api/orders/user/email/{email}
GET    /api/orders/user/{userId}
GET    /api/orders/{id}
PUT    /api/orders/{id}/status?status={status}
```

The order controller supports order creation, all-order retrieval, retrieval by email/user ID, single-order lookup and status updates. fileciteturn138file0

## AI

```text
POST   /api/ai/chat
GET    /api/ai/recommendations
```

## Razorpay

```text
POST   /api/payment/razorpay/create-order
POST   /api/payment/razorpay/verify-signature
```

## Email

```text
POST   /api/email/order-confirmation
POST   /api/email/order-cancellation
```

---

# 🧭 Frontend Routes

The application includes pages for the main shopping experience, including:

| Route / Page | Purpose |
|---|---|
| Home | Landing page and product discovery |
| Products | Browse/search/filter catalog |
| Product Details | Detailed product information |
| Login | User authentication |
| Register | New account registration |
| Cart | Review cart items |
| Checkout | Shipping, coupon and payment |
| Wishlist | Saved products |
| Profile | Customer profile and orders |
| AI Assistant | Shopping assistant |
| Admin Dashboard | Administrative controls |
| Not Found | 404 page |

> Exact route paths can be checked in the frontend router configuration.

---

# 🧪 Testing Checklist

Use this checklist when validating the application locally.

## Backend

- [ ] MySQL service is running
- [ ] Backend starts without exceptions
- [ ] `/api/products` responds successfully
- [ ] Category endpoint works
- [ ] Search endpoint works
- [ ] Registration endpoint works
- [ ] OTP verification works
- [ ] Login returns authentication data
- [ ] Order endpoints respond correctly
- [ ] Razorpay order creation succeeds in Test Mode
- [ ] Razorpay signature verification rejects invalid data
- [ ] Email endpoint succeeds when SMTP is configured

## Frontend

- [ ] Home page loads
- [ ] Product page loads
- [ ] Search works
- [ ] Filters work
- [ ] Product details open
- [ ] Cart add/remove/update works
- [ ] Wishlist works
- [ ] Coupon application works
- [ ] Checkout validation works
- [ ] Razorpay checkout opens
- [ ] COD flow works
- [ ] Profile page loads
- [ ] Admin dashboard loads for an admin account
- [ ] Theme switching works
- [ ] Responsive behavior works on smaller screens

## Payment

- [ ] Razorpay Test Mode is enabled
- [ ] `RAZORPAY_KEY_ID` is configured
- [ ] `RAZORPAY_KEY_SECRET` is configured
- [ ] Backend creates a real Razorpay Test Order
- [ ] Frontend receives the Razorpay order ID
- [ ] Checkout launches using the order ID
- [ ] Payment callback data is captured
- [ ] Signature verification is performed server-side
- [ ] No production payment credentials are used during testing

---

# 🔎 Useful Local Test Commands

## Check backend build

```powershell
cd megavault-backend
mvn clean compile
```

## Package backend

```powershell
mvn clean package
```

## Run backend

```powershell
mvn spring-boot:run
```

## Install frontend

```powershell
cd ..\megavault-frontend
npm install
```

## Run frontend

```powershell
npm run dev
```

## Production frontend build

```powershell
npm run build
```

---

# 🏭 Build & Production Preparation

Before deploying this project publicly, complete the following:

### 1. Move all secrets to environment variables

This includes:

- MySQL password
- JWT signing secret
- Razorpay secret
- SMTP credentials
- Any future AI API keys

### 2. Configure a production database

Use a managed MySQL instance or properly secured MySQL server instead of a developer workstation database.

### 3. Restrict CORS

The current local configuration allows the React development origin. A production deployment should allow only the real deployed frontend domain.

### 4. Use HTTPS

Payment and authentication traffic should be protected by HTTPS in production.

### 5. Separate Test Mode and Live Mode

Never mix Razorpay Test credentials with production payment credentials.

### 6. Add automated tests

Add unit and integration tests for:

- Auth service
- Product service
- Order service
- Payment verification
- Coupon calculations
- Controller validation

### 7. Add CI/CD

A GitHub Actions pipeline can automatically build and test both frontend and backend on every push.

---

# ⚠️ Known Limitations

The current codebase is a strong development/internship project, but some areas should be hardened before production deployment.

### 1. Some shopping UI data is handled locally

Parts of the frontend catalog experience use local/mock data and client-side filtering. For a production e-commerce system, product data should consistently come from the backend/database.

### 2. AI assistant is rule-based

The current `/api/ai/chat` implementation scores catalog products based on keyword/category/budget matching rather than calling a full external generative AI service. fileciteturn139file0

### 3. QR UI should not be treated as payment proof

Displaying a generated QR image is not the same as confirming a successful payment. Payment status should be driven by verified Razorpay transaction data.

### 4. Order persistence should be verified end-to-end

The backend has real order APIs, but the frontend checkout flow should be tested carefully to ensure the final order is persisted through `/api/orders` rather than only stored in client-side state.

### 5. Localhost configuration

The current CORS/payment setup is designed for local development and should be externalized before deployment.

### 6. Production validation

The application should receive a complete security review before real customer use, especially around authorization, payment confirmation, secrets, validation and admin endpoints.

---

# 🔮 Future Enhancements

Potential next steps:

- Real production deployment
- Full backend-driven product catalog
- Persistent cart and wishlist
- Database-backed coupon engine
- Payment webhook handling
- Order payment status synchronization
- Real inventory management
- Product review/rating system
- Advanced search and pagination
- AI-powered personalized recommendations
- External LLM integration
- Semantic product search
- Admin analytics dashboards
- Sales reports
- Order tracking
- Shipping integration
- Cloud object storage for product images
- Redis caching
- Automated API tests
- Frontend component testing
- End-to-end browser testing
- Docker support
- GitHub Actions CI/CD
- Production observability/logging

---

# 📚 Documentation

The repository also includes additional project material:

### 📄 Detailed documentation

```text
MegaVault_documentation.pdf
```

### 📊 Project presentation

```text
MegaVault_ppt.pptx
```

These files can be used to understand the project presentation, functional scope and overall project documentation.

---

# 🧑‍💻 Author

**Chandra Shekar**

GitHub: **[@Chandrashekar1404](https://github.com/Chandrashekar1404)**

Repository: **[ecom-fullstack](https://github.com/Chandrashekar1404/ecom-fullstack)**

---

# 📜 License

This project is intended primarily for educational, internship, portfolio and demonstration purposes.

Before using the project commercially, review and add an explicit open-source license appropriate to your intended use.

---

## ⭐ Support the Project

If you find MegaVault useful for learning full-stack development, consider starring the repository and using it as a starting point for your own improvements.

```text
Built with React ⚛️ + Spring Boot ☕ + MySQL 🗄️ + Razorpay 💳
```

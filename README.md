# MegaVault AI Powered Ecommerce Platform

MegaVault is an AI-powered full-stack e-commerce platform developed as an internship project. It combines modern e-commerce functionality with AI assistance to provide users with a smarter, personalized, and user-friendly online shopping experience.

## 🚀 Project Overview

MegaVault provides a complete digital shopping experience where users can browse products, search for items, manage their cart and wishlist, apply coupons, complete checkout, manage their profiles, and interact with an AI-powered shopping assistant.

The platform also includes an administrative dashboard for managing and monitoring the e-commerce system.

## ✨ Key Features

### 🛍️ E-Commerce Features

* User registration and login
* Product browsing
* Product search and filtering
* Product details
* Shopping cart
* Wishlist management
* Checkout system
* Coupon and discount support
* User profile management
* Responsive design

### 🤖 AI-Powered Features

* AI shopping assistant
* Intelligent product assistance
* AI-based user interaction
* AI service integration through the application backend
* Personalized shopping support

### 👨‍💼 Admin Features

* Admin dashboard
* Product management
* Store management
* Administrative controls
* Dashboard overview

### 🎨 User Experience

* Modern and responsive UI
* Theme support
* Reusable React components
* Mobile-friendly design
* Clean navigation
* Consistent styling system

## 🛠️ Technologies Used

### Frontend

* React.js
* Vite
* JavaScript
* HTML5
* CSS3
* React Router
* Context API

### Backend

* Node.js
* Express.js
* REST APIs

### AI Integration

* Grok AI API / AI service integration

### Tools

* Git
* GitHub
* Visual Studio Code
* npm

## 📂 Project Structure

```text
MegaVault_Ecommerce/
│
├── megavault-frontend/
│   ├── src/
│   │   ├── components/
│   │   ├── context/
│   │   ├── layouts/
│   │   ├── pages/
│   │   ├── routes/
│   │   ├── services/
│   │   ├── styles/
│   │   ├── utils/
│   │   └── main.jsx
│   │
│   ├── public/
│   ├── package.json
│   └── vite.config.js
│
├── megavault-backend/
│   ├── src/
│   ├── routes/
│   ├── controllers/
│   ├── models/
│   └── package.json
│
├── MegaVault_documentation.pdf
├── MegaVault_ppt.pptx
├── README.md
└── .gitignore
```

## 📄 Main Application Pages

MegaVault includes the following major pages:

* Home
* Products
* Product Details
* Login
* Register
* Cart
* Checkout
* Wishlist
* Profile
* AI Assistant
* Admin Dashboard
* 404 / Not Found

## 🔄 User Shopping Flow

```text
Register / Login
       ↓
Browse Products
       ↓
Search / Filter Products
       ↓
View Product Details
       ↓
Add to Cart / Wishlist
       ↓
Apply Coupon
       ↓
Checkout
       ↓
Complete Purchase
```

## 🤖 AI Shopping Assistant

One of the main highlights of MegaVault is its AI-powered shopping assistant.

The AI assistant is designed to help users with shopping-related interactions and provide intelligent assistance while navigating the platform.

The project includes an AI service integration:

```text
megavault-frontend/src/services/grokService.js
```

API keys and other sensitive credentials should be stored in environment variables and should never be committed to the repository.

## 🎨 Theme and State Management

MegaVault uses React Context API to manage shared application state.

Important contexts include:

* `ThemeContext`
* `WishlistContext`

The application also uses reusable layouts, routes, services, and utility modules to maintain a modular and scalable architecture.

## ⚙️ Installation

### 1. Clone the Repository

```bash
git clone https://github.com/saitejin/MegaVault_Internship-Project.git
```

```bash
cd MegaVault_Internship-Project
```

### 2. Install Frontend Dependencies

```bash
cd megavault-frontend
npm install
```

### 3. Start the Frontend

```bash
npm run dev
```

The Vite development server will normally run at:

```text
http://localhost:5173
```

### 4. Install Backend Dependencies

Open another terminal:

```bash
cd megavault-backend
npm install
```

Start the backend using the appropriate script from `package.json`:

```bash
npm run dev
```

or:

```bash
npm start
```

## 🔐 Environment Variables

If environment variables are required, create a `.env` file in the appropriate directory.

Example:

```env
PORT=5000
API_KEY=your_api_key
DATABASE_URL=your_database_url
```

Never commit real API keys, passwords, database credentials, or other sensitive information to GitHub.

## 📚 Project Documentation

Detailed project documentation is included in:

**MegaVault_documentation.pdf**

The project presentation is available in:

**MegaVault_ppt.pptx**

## 🔮 Future Enhancements

Future versions of MegaVault can include:

* Online payment gateway integration
* Order tracking
* Product reviews and ratings
* AI-powered product recommendations
* Personalized product suggestions
* Advanced admin analytics
* Inventory management
* Real-time notifications
* Cloud deployment
* Automated testing
* Advanced recommendation systems

## 👨‍💻 Author

**Sai Tejin**

MegaVault AI Powered Ecommerce Platform was developed as an internship project to demonstrate skills in full-stack development, e-commerce application development, React, backend APIs, AI integration, and modern web technologies.

## 📜 License

This project was developed for educational and internship purposes.

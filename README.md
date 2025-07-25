# DROPSELL

A fullstack mobile application for Online Shop that includes user authentication, Buying items, and a modern front-end interface.

---------------------

## 🧰 Tech Stack

**Backend**  
- Java  
- Spring Boot  
- PostgreSQL  

**Frontend**  
- Angular (TypeScript)
- Ionic (TypeScript)  
- HTML / SCSS

**Other**  
- Git & GitHub  
- Node.js (for frontend)  
- Maven (for backend)  

## 🛠 Backend Configuration (Spring Boot)

Before running the backend, make sure to configure the following in the `application.properties` file:

  ### 🔧 Database Configuration
  
  spring.datasource.url=jdbc:mysql://localhost:3306/your_database
  spring.datasource.username=your_username
  spring.datasource.password=your_password
  
## 🎨 Frontend Setup (AngularTS + IonicTS)

After cloning the project, navigate to the frontend folder:
cd frontend
Then install the required dependencies:
npm install --legacy-peer-deps
Once finished, you can start the development server:
ionic serve

📂 Project Structure
java
DROPSELL/
├── BACK-END/      → Spring Boot (Java)
├── FRONT-END/     → AngularTS (Typescript) +  IonicTS (Typescript)
└── README.md

✅ Notes
This project is not fully containerized. You can add Docker support for deployment.

Make sure your backend is running before testing the frontend APIs.

📬 Contact
For questions or support, feel free to reach out via GitHub issues or email.

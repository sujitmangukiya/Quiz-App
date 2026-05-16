# 🧠 Quiz Application (Spring Boot)

A backend Quiz Application built using **Spring Boot** that allows users to attempt quizzes, submit answers, and receive results through REST APIs.

---

## 🚀 Features

* ❓ Start Quiz
* 📥 Get Questions
* ✅ Submit Answers
* 📊 Result Calculation
* 🔄 Sequential Question Flow
* 🌐 REST API Based System

---

## 🏗️ Project Architecture

```text
Controller → Service → Repository → Database
           ↓
         Model
```

* **Controller** → Handles API requests
* **Service** → Business logic (quiz flow, answer checking)
* **Repository** → Database interaction
* **Model** → Entity classes (Quiz / Question / Answer)

---

## 🛠️ Tech Stack

* ☕ Java (Spring Boot)
* 🌐 REST APIs
* 🗄️ Spring Data JPA (Hibernate)
* 🛢️ MySQL Database

---

## ⚙️ API Endpoints

---

### 🔹 1. Start Quiz

**GET** `/quiz/start`

📌 Starts the quiz session

---

### 🔹 2. Get Question

**GET** `/quiz/question`

📌 Returns next question

---

### 🔹 3. Submit Answer

**POST** `/quiz/answer`

```json
{
  "questionId": 1,
  "answer": "A"
}
```

📌 Submits answer and processes result

---

### 🔹 4. Get Result

**GET** `/quiz/result`

📌 Returns final score

---

## 🔄 Application Flow

1️⃣ Start Quiz
2️⃣ Get Question
3️⃣ Submit Answer
4️⃣ Next Question
5️⃣ Repeat
6️⃣ Show Result

---

## 🧠 Business Logic Highlights

* ✅ Questions handled through backend logic
* ✅ One-by-one question flow
* ✅ Answer validation system
* ✅ Score calculation
* ✅ Clean layered architecture

---

## ⚠️ Error Handling

* ❌ Quiz Not Started
* ❌ Invalid Question ID
* ❌ Invalid Answer
* ❌ No More Questions

---

## 🔧 Setup Instructions

### 1️⃣ Clone Repository

```bash
git clone https://github.com/sujitmangukiya/Quiz-App.git
```

---

### 2️⃣ Configure Database

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=root
spring.datasource.password=your_password
```

---

### 3️⃣ Run Application

```bash
Run main Spring Boot application class
```

---

## 👨‍💻 Author

**Sujit Mangukiya**
🚀 Java Backend Developer 

---

## ⭐ Support

If you find this project useful, give it a ⭐ on GitHub!

---

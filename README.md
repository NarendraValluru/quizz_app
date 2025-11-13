# Quiz Application
A Spring Boot-based Quiz Application for creating, managing, and taking quizzes with a flexible category system. Developed with a modern MVC architecture (Controller-Service-DAO).

# Features:
* Create Quizzes by selecting categories and number of questions
* Add, View, and Filter Questions (by category and difficulty level)
* Take Quizzes and submit responses
* Score Calculation based on user answers
* RESTful API design using Spring Boot & JPA

# Tech Stack
* Backend: Java Spring Boot
* ORM: JPA & Hibernate
* Database: (MySQL)
* Build Tool: Maven

# Project Structure
```
src /
├── controller /           # REST controllers (QuizzController, QuestionController)
├── service/              # Business logic (QuizzService, QuestionService)
├── dao/                  # Data access objects (QuizzDao, QuestionDao)
├── model/                # Entity models (Question, Quizz, Response, QuestionWrapper)
```

# API Endpoints

| Method | Endpoint                      | Description                  |
| ------ | ----------------------------- | ---------------------------- |
| POST   | /question/savequestions       | Add a new question           |
| GET    | /question/allquestions        | Fetch all questions          |
| GET    | /question/category/{category} | Filter questions by category |
| POST   | /quizz/create                 | Create a new quiz            |
| GET    | /quizz/get/{id}               | Get questions for a quiz     |
| POST   | /quizz/submit/{id}            | Submit answers for scoring   |

# How To Run
1. Clone the repository:
   * git clone https://github.com/NarendraValluru/quizz_app.git
2. Configure database in application.properties
3. Build and run the project
   * mvn spring-boot:run
4. Access API endpoints via Postman or any REST client



  


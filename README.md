# 🌱 EcoGuide AI — Sustainable Living Assistant

**EcoGuide AI** is a beginner-friendly sustainability-focused Java web application developed for the **1M1B AI for Sustainability Virtual Internship**.

The application helps users make more sustainable everyday decisions by providing practical recommendations related to **water, energy, waste, food, transportation, and daily habits**.

The primary focus of the project is:

> **SDG 12 — Responsible Consumption and Production**

The current version uses an **explainable Java keyword-based recommendation prototype**. The architecture is designed so that the recommendation layer can be extended with **IBM Granite, RAG, Agentic AI, and IBM BOB/watsonx-based AI services** in future versions.

---

## 🌍 Project Overview

Everyday activities such as electricity usage, water consumption, food waste, plastic usage, and transportation choices have an impact on sustainability.

EcoGuide AI provides a simple conversational interface where users can ask questions such as:

* How can I save electricity?
* How can I save water?
* How can I reduce plastic?
* How can I reduce food waste?
* How can I use public transportation?
* What are some sustainable daily habits?

The application analyzes the question, identifies the sustainability category, generates a recommendation, calculates a prototype Eco Score, identifies the related SDG, and stores the interaction in MySQL.

---

# ✨ Features

* 💬 Chat-style sustainability assistant
* 🌊 Water conservation recommendations
* ⚡ Energy-saving recommendations
* ♻️ Waste and plastic reduction recommendations
* 🍎 Food-waste reduction recommendations
* 🚌 Sustainable transportation recommendations
* 🌱 Daily sustainable habit recommendations
* 🧠 Explainable Java keyword-based recommendation logic
* 📊 Prototype Eco Score
* 🎯 Sustainability category detection
* 🌍 Related SDG identification
* 💾 JDBC-based MySQL persistence
* 🔐 PreparedStatement-based database operations
* ✅ Input validation
* 🛡️ Graceful database error handling
* 🔑 No hard-coded database passwords
* 📱 Responsive HTML/CSS interface
* 🔄 JSON-based frontend/backend communication
* 🚀 Maven-based build
* 📦 WAR deployment on Apache Tomcat

---

# 👋 Welcome Greeting

EcoGuide AI includes a friendly conversational greeting:

> **"Hello! 👋 I'm EcoGuide AI, your Sustainable Living Assistant. 🌱 Ask me about saving water, energy, reducing waste, sustainable food, transportation, or everyday green habits."**

The greeting provides a simple and welcoming entry point for users before they begin asking sustainability-related questions.

---

# 🎯 Sustainable Development Goals

## Primary SDG

### SDG 12 — Responsible Consumption and Production

EcoGuide AI primarily supports responsible consumption by encouraging users to reduce waste, conserve resources, and make more sustainable daily choices.

## Secondary SDGs

| SDG        | Area                                   | EcoGuide AI Connection                      |
| ---------- | -------------------------------------- | ------------------------------------------- |
| **SDG 6**  | Clean Water and Sanitation             | Water conservation                          |
| **SDG 7**  | Affordable and Clean Energy            | Energy-saving practices                     |
| **SDG 11** | Sustainable Cities and Communities     | Sustainable transportation                  |
| **SDG 12** | Responsible Consumption and Production | Waste reduction and responsible consumption |
| **SDG 13** | Climate Action                         | Environmentally conscious daily choices     |

---

# 🛠️ Technologies Used

## Frontend

* **HTML5**
* **CSS3**
* **Vanilla JavaScript ES6**

## Backend

* **Java 21**
* **Jakarta Servlet 6.1**

## Database

* **MySQL 8**
* **JDBC**
* **PreparedStatement**

## Server

* **Apache Tomcat 11**

## Build and Version Control

* **Maven**
* **Git**

---

# 🤖 AI Technologies

## Current Prototype

The current deployed prototype uses:

### Explainable Keyword-Based Recommendation Logic

The Java backend analyzes keywords in the user's question and identifies the relevant sustainability category.

For example:

```text
User Question
      ↓
Keyword Analysis
      ↓
Identify Category
      ↓
Generate Recommendation
      ↓
Eco Score
```

Example:

```text
Question:
"How can I save electricity?"

Detected Category:
Energy

Eco Score:
90

Related SDG:
SDG 7
```

This approach is intentionally simple, transparent, and explainable.

---

# 🚀 Future AI Architecture

The project is designed to evolve from the current rule-based prototype into a more advanced Generative AI sustainability assistant.

Future architecture:

```text
User Question
      ↓
Java Servlet
      ↓
AI Service
      ↓
RAG / Knowledge Retrieval
      ↓
IBM Granite / Generative AI
      ↓
Agentic AI Layer
      ↓
Sustainability Recommendation
      ↓
Eco Score
      ↓
MySQL
```

---

# 🧠 IBM Granite

**IBM Granite** can be used as the future Generative AI model layer.

Instead of relying only on predefined keywords, Granite could analyze the meaning and context of the user's question and generate a more flexible sustainability recommendation.

Example:

```text
User:
"I have a very high electricity bill.
What can I do to reduce my energy consumption?"

Future AI:
Analyze the context
        ↓
Identify energy-related problem
        ↓
Generate personalized sustainability suggestions
        ↓
Return recommendation
```

**Status:** Future AI integration.

---

# 📚 RAG — Retrieval-Augmented Generation

A future version can use **RAG (Retrieval-Augmented Generation)** to improve the reliability of sustainability recommendations.

Instead of allowing the AI model to generate an answer only from its internal knowledge, the system can retrieve information from a trusted sustainability knowledge base.

Possible flow:

```text
User Question
      ↓
Retrieve Relevant Sustainability Information
      ↓
Provide Retrieved Context to AI
      ↓
IBM Granite
      ↓
Generated Recommendation
```

Potential knowledge sources could include trusted sustainability guidelines, organizational resources, and verified environmental information.

**Status:** Planned future enhancement.

---

# 🤖 Agentic AI

A future Agentic AI layer could allow EcoGuide AI to handle more complex sustainability tasks.

For example:

```text
User Request
      ↓
AI Agent
      ↓
Understand Goal
      ↓
Select Appropriate Action
      ↓
Retrieve Information
      ↓
Generate Recommendation
      ↓
Return Result
```

An agent could potentially decide whether a request requires:

* Sustainability knowledge retrieval
* Energy recommendations
* Water recommendations
* Waste recommendations
* Transportation guidance
* Additional clarification

**Status:** Planned future enhancement.

---

# 🏢 IBM BOB / IBM watsonx

The future architecture can also be extended with IBM enterprise AI services such as **IBM BOB / watsonx-based capabilities**, depending on the available internship environment and integration requirements.

These services can potentially provide an enterprise-oriented layer for AI interaction, model access, governance, or application integration.

**Status:** Future integration / architecture option.

> **Important:** IBM Granite, RAG, Agentic AI, and IBM BOB/watsonx are identified as future AI capabilities unless they are explicitly configured and running in the deployed application.

---

# 🏗️ System Architecture

## Current Architecture

```text
                ┌─────────────────────┐
                │       User          │
                └──────────┬──────────┘
                           │
                           ↓
                ┌─────────────────────┐
                │ HTML/CSS/JavaScript │
                └──────────┬──────────┘
                           │
                           ↓
                ┌─────────────────────┐
                │   Java Servlet      │
                └──────────┬──────────┘
                           │
                           ↓
                ┌─────────────────────┐
                │  Input Validation   │
                └──────────┬──────────┘
                           │
                           ↓
                ┌─────────────────────┐
                │  Keyword Analysis  │
                └──────────┬──────────┘
                           │
                           ↓
                ┌─────────────────────┐
                │generateAIResponse() │
                └──────────┬──────────┘
                           │
                           ↓
                ┌─────────────────────┐
                │ Recommendation +    │
                │ Category + SDG +    │
                │ Eco Score           │
                └──────────┬──────────┘
                           │
                  ┌────────┴────────┐
                  ↓                 ↓
          ┌───────────────┐   ┌────────────┐
          │    MySQL      │   │ JSON       │
          │   Database    │   │ Response   │
          └───────────────┘   └─────┬──────┘
                                    │
                                    ↓
                            ┌──────────────┐
                            │  Frontend    │
                            └──────────────┘
```

---

# 🔄 Complete Request Flow

The complete application flow is:

```text
User Question
      ↓
Java Servlet
      ↓
Analyze Question
      ↓
Identify Sustainability Category
      ↓
Generate Recommendation
      ↓
Calculate Eco Score
      ↓
Identify Related SDG
      ↓
Save to MySQL
      ↓
Return JSON
      ↓
Display Result
```

---

# 📊 Eco Score

EcoGuide AI currently uses a transparent prototype indicator for each sustainability category.

| Category       | Prototype Eco Score |
| -------------- | ------------------: |
| Water          |              **85** |
| Energy         |              **90** |
| Waste          |              **88** |
| Food           |              **82** |
| Transportation |              **86** |
| Daily Habits   |              **80** |

### ⚠️ Important

The Eco Score is:

* A prototype indicator
* Not scientifically validated
* Not a measurement of actual carbon footprint
* Not a measurement of actual environmental impact

The score is included to demonstrate how sustainability information could be represented in the application.

---

# 🔐 Security and Reliability

EcoGuide AI follows basic secure-development practices.

### PreparedStatement

Database operations use JDBC `PreparedStatement` to avoid directly constructing SQL statements from user input.

### Environment Variables

Database credentials are not hard-coded into the source code.

Example:

```bash
export DB_USER=ecoguide_app
export DB_PASSWORD='your-local-password'
export DB_URL='jdbc:mysql://localhost:3306/ecoguide_ai?useSSL=false&serverTimezone=UTC'
export ALLOWED_ORIGIN='http://localhost:8080'
```

### Input Validation

The application validates:

* Empty questions
* Question length
* Unexpected input
* Unrelated questions

The maximum question length is **500 characters**.

### Error Handling

Database errors are handled gracefully.

The application does not expose Java stack traces or database credentials to browser users.

---

# 🗄️ Database

Database name:

```text
ecoguide_ai
```

The application stores submitted questions and generated results in the `questions` table.

Example verification:

```sql
USE ecoguide_ai;

SELECT *
FROM questions
ORDER BY created_at DESC;
```

---

# 🔌 API

## Ask Sustainability Question

### Endpoint

```text
POST /EcoGuideAI/api/ask
```

### Request

```json
{
  "question": "How can I save electricity?"
}
```

### Response

The JSON response contains:

```text
success
question
answer
category
ecoScore
sdg
databaseSaved
```

Example structure:

```json
{
  "success": true,
  "question": "How can I save electricity?",
  "answer": "Use energy-efficient appliances and switch off devices when they are not required.",
  "category": "Energy",
  "ecoScore": 90,
  "sdg": "SDG 7",
  "databaseSaved": true
}
```

---

# 💻 Local Setup

## Requirements

Install:

* Java 21
* Maven
* MySQL 8
* Apache Tomcat 11
* Git

---

## 1. Clone the Repository

```bash
git clone <your-repository-url>
cd ecoguide-ai
```

---

## 2. Configure MySQL

Create the database and restricted application user using:

```bash
mysql -u root -p < database-setup.sql
```

Make sure the placeholder password in the setup process is replaced with your own local password.

---

## 3. Configure Environment Variables

Set the variables in the same terminal environment used to start Tomcat:

```bash
export DB_USER=ecoguide_app

export DB_PASSWORD='your-local-password'

export DB_URL='jdbc:mysql://localhost:3306/ecoguide_ai?useSSL=false&serverTimezone=UTC'

export ALLOWED_ORIGIN='http://localhost:8080'
```

Never commit the real database password to GitHub.

---

# 📦 Build the Application

Run:

```bash
mvn clean package
```

The WAR file will be generated inside:

```text
target/
```

---

# 🚀 Deploy to Tomcat

Copy the generated WAR file:

```bash
cp target/EcoGuideAI.war /usr/local/opt/tomcat/libexec/webapps/
```

Start Tomcat:

```bash
/usr/local/opt/tomcat/libexec/bin/catalina.sh run
```

Open:

```text
http://localhost:8080/EcoGuideAI/
```

If Tomcat was started using `catalina.sh run`, stop it using:

```text
Ctrl + C
```

---

# 🧪 Testing

The following questions can be used for demonstration.

### Energy

```text
How can I save electricity?
```

Expected category:

```text
Energy
```

Prototype score:

```text
90
```

---

### Water

```text
How can I save water?
```

Expected category:

```text
Water
```

Prototype score:

```text
85
```

---

### Waste

```text
How can I reduce plastic?
```

Expected category:

```text
Waste
```

Prototype score:

```text
88
```

---

### Food

```text
How can I reduce food waste?
```

Expected category:

```text
Food
```

Prototype score:

```text
82
```

---

### Transportation

```text
How can I use public transportation?
```

Expected category:

```text
Transportation
```

Prototype score:

```text
86
```

---

# 🧪 Validation Tests

The application should also be tested with:

### Empty Question

```text
```

### Very Long Question

More than:

```text
500 characters
```

### Special Characters

```text
@@@###$$$
```

### Unrelated Question

```text
What is the capital of France?
```

### Database Failure

Temporarily make the database unavailable and verify that the browser receives a graceful error rather than a server stack trace.

---

# ☁️ Vercel and Production Deployment

Vercel can host the **static frontend**, but it does not run a Tomcat/Jakarta Servlet WAR backend.

Therefore, production architecture should be:

```text
Vercel
  │
  │ HTTPS
  ↓
Java / Tomcat Backend
  │
  ↓
Managed MySQL
```

Before deploying the frontend, configure:

```javascript
window.ECOGUIDE_API_BASE_URL
```

inside:

```text
src/main/webapp/js/config.js
```

The value should point to the HTTPS URL of the Java/Tomcat backend.

The Java backend should configure:

```text
ALLOWED_ORIGIN
```

to the exact production frontend origin.

### Production Database

Production requires a reachable managed MySQL database.

Database passwords must never be stored in GitHub or exposed in frontend JavaScript.

The backend remains Java-based.

There is no requirement to convert the application to:

* Node.js
* Express
* Spring Boot
* Serverless JavaScript

---

# 🤝 Responsible AI

EcoGuide AI follows several Responsible AI principles.

## Transparency

The current implementation clearly identifies itself as a keyword-based prototype rather than falsely claiming to be a Generative AI model.

## Fairness

Recommendations are designed to provide general sustainability guidance without making decisions based on sensitive personal characteristics.

## Privacy

The application avoids unnecessary personal-data collection.

## Accuracy

The project avoids presenting unsupported environmental claims as scientific facts.

## Explainability

The current keyword-based recommendation logic makes it possible to understand why a category and recommendation were selected.

## Human Responsibility

EcoGuide AI provides suggestions. Users remain responsible for their own decisions and actions.

---

# ⚠️ Current Limitations

The current prototype has several limitations:

* Keyword-based matching is limited compared with Generative AI.
* Similar questions may not always be categorized correctly.
* Recommendations are predefined.
* The Eco Score is not scientifically validated.
* The system does not currently provide personalized environmental impact calculations.
* RAG is not currently implemented in the prototype.
* Agentic AI is not currently implemented in the prototype.
* IBM Granite is planned for future AI integration.
* IBM BOB/watsonx integration is planned as a future AI capability.

These limitations provide clear opportunities for future development.

---

# 🔮 Future Scope

## 1. IBM Granite Integration

Replace or augment the keyword-based recommendation system with IBM Granite for more flexible natural-language responses.

## 2. RAG

Build a trusted sustainability knowledge base and use Retrieval-Augmented Generation to provide responses based on retrieved information.

## 3. Agentic AI

Introduce an AI agent capable of understanding user goals and selecting appropriate sustainability tools or knowledge sources.

## 4. Multilingual Support

Support multiple languages so sustainability guidance can reach a wider audience.

## 5. Improved Classification

Use more advanced semantic understanding to classify questions into sustainability categories.

## 6. Privacy-Aware Analytics

Add analytics while minimizing collection and storage of personal information.

## 7. Administrator Dashboard

Provide authenticated administrators with sustainability usage statistics and reports.

## 8. Improved Eco Score

Future versions could use transparent, evidence-based calculations rather than fixed prototype scores.

---

# 📸 Screenshots

Add screenshots after successful local deployment.

Recommended screenshots:

### 1. Home Page

```text
screenshots/home-page.png
```

### 2. Chat Result

```text
screenshots/chat-result.png
```

### 3. MySQL Record

```text
screenshots/mysql-record.png
```

---

# 🎬 Project Demonstration

Recommended demonstration sequence:

```text
1. Introduction
       ↓
2. Project Objective
       ↓
3. Features
       ↓
4. SDG Alignment
       ↓
5. Technology Stack
       ↓
6. Architecture
       ↓
7. Greeting
       ↓
8. Energy Question
       ↓
9. Water Question
       ↓
10. Waste Question
       ↓
11. Food Question
       ↓
12. Transportation Question
       ↓
13. MySQL Database
       ↓
14. Input Validation
       ↓
15. Responsible AI
       ↓
16. Future AI Architecture
       ↓
17. Conclusion
```

---

# 📌 Project Summary

| Item                     | Details                                          |
| ------------------------ | ------------------------------------------------ |
| **Project**              | EcoGuide AI                                      |
| **Type**                 | Sustainable Living Assistant                     |
| **Internship**           | 1M1B AI for Sustainability Virtual Internship    |
| **Primary SDG**          | SDG 12                                           |
| **Frontend**             | HTML5, CSS3, Vanilla JavaScript                  |
| **Backend**              | Java 21, Jakarta Servlet 6.1                     |
| **Database**             | MySQL 8                                          |
| **Connectivity**         | JDBC                                             |
| **Server**               | Apache Tomcat 11                                 |
| **Build Tool**           | Maven                                            |
| **Version Control**      | Git                                              |
| **Current AI**           | Explainable keyword-based prototype              |
| **Future AI**            | IBM Granite, RAG, Agentic AI                     |
| **Future Enterprise AI** | IBM BOB / watsonx-based integration              |
| **Deployment**           | Tomcat backend + optional Vercel static frontend |

---

# 🌱 Conclusion

EcoGuide AI demonstrates how a simple web application can encourage sustainable everyday choices through technology.

The current prototype combines:

**HTML + CSS + JavaScript + Java + Jakarta Servlet + JDBC + MySQL + Tomcat**

to provide sustainability recommendations through an explainable rule-based approach.

The architecture is intentionally designed for future AI enhancement through:

**RAG + IBM Granite + Agentic AI + IBM BOB/watsonx**

This provides a clear path from a beginner-friendly prototype to a more intelligent, knowledge-grounded, and responsible sustainability assistant.

---

## 👨‍💻 Author

**Ritvik Raj**

**Project:** EcoGuide AI — Sustainable Living Assistant

**Focus:** AI for Sustainability

**Primary SDG:** SDG 12 — Responsible Consumption and Production

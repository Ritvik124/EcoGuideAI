# EcoGuide AI — Sustainable Living Assistant

EcoGuide AI is a beginner-friendly Java web application for the **1M1B AI for Sustainability Virtual Internship**. It gives practical guidance about sustainable daily choices, with **SDG 12: Responsible Consumption and Production** as its primary focus.

## Features

- Chat-style questions for water, energy, waste, food, transportation, and daily habits
- Explainable Java keyword-based prototype recommendation logic
- Category, related SDG, and Eco Score — Prototype Indicator
- JDBC persistence to MySQL using `PreparedStatement`
- Responsive HTML, CSS, and vanilla JavaScript interface
- Input validation, graceful database errors, and no hard-coded secrets

## SDG alignment

Primary: **SDG 12 — Responsible Consumption and Production**. Secondary: SDG 6 (Clean Water and Sanitation), SDG 7 (Affordable and Clean Energy), SDG 11 (Sustainable Cities and Communities), and SDG 13 (Climate Action).

## Technology stack

HTML5, CSS3, Vanilla JavaScript ES6, Java 21, Jakarta Servlet 6.1, JDBC, MySQL 8, Apache Tomcat 11, Maven, and Git.

## Architecture and workflow

**Current prototype:** User Question → Java Servlet → Keyword Analysis → `generateAIResponse()` → Recommendation.

**Future AI:** User Question → Java Servlet → AI Service → IBM Granite / Generative AI → Sustainability Recommendation → Eco Score.

Full request flow: User Question → Java Servlet → Analyze Question → Identify Sustainability Category → Generate Recommendation → Calculate Eco Score → Save to MySQL → Return JSON → Display Result.

The score is a transparent prototype indicator (Water 85, Energy 90, Waste 88, Food 82, Transportation 86, Daily Habits 80); it is not a scientifically validated environmental measurement.

## Local setup

1. Install Java 21, Maven, MySQL 8, and Tomcat 11.
2. Create the database and restricted local user. Replace the placeholder password before running this command:

```bash
mysql -u root -p < database-setup.sql
```

3. Set Tomcat environment variables in the terminal that starts Tomcat:

```bash
export DB_USER=ecoguide_app
export DB_PASSWORD='your-local-password'
export DB_URL='jdbc:mysql://localhost:3306/ecoguide_ai?useSSL=false&serverTimezone=UTC'
export ALLOWED_ORIGIN='http://localhost:8080'
```

4. Build and deploy:

```bash
mvn clean package
cp target/EcoGuideAI.war /usr/local/opt/tomcat/libexec/webapps/
/usr/local/opt/tomcat/libexec/bin/catalina.sh run
```

Open <http://localhost:8080/EcoGuideAI/>. Stop Tomcat with `Ctrl+C` if it was started with `run`.

## Tests

Try these questions: `How can I save electricity?`, `How can I save water?`, `How can I reduce plastic?`, `How can I reduce food waste?`, and `How can I use public transportation?`.

Verify persisted records with:

```sql
USE ecoguide_ai;
SELECT * FROM questions ORDER BY created_at DESC;
```

Also test an empty question, a question over 500 characters, special characters, and an unrelated question. Database problems do not expose a stack trace to browser users.

## API

`POST /EcoGuideAI/api/ask`

```json
{"question":"How can I save electricity?"}
```

The JSON response contains `success`, `question`, `answer`, `category`, `ecoScore`, `sdg`, and `databaseSaved`.

## Vercel and production

Vercel can host this static frontend, but it does **not** run a Tomcat/Jakarta Servlet WAR. Before Vercel deployment, set `window.ECOGUIDE_API_BASE_URL` in `src/main/webapp/js/config.js` to the HTTPS URL of a Java/Tomcat-capable backend, then deploy the frontend files. Set `ALLOWED_ORIGIN` on the Java host to the exact Vercel origin. Production also needs a reachable managed MySQL database; never expose its password in GitHub.

Suitable backend options are a Java/Tomcat-capable VM or platform service. The backend remains Java—there is no Node.js, Express, Spring Boot, or serverless JavaScript conversion.

## Responsible AI

The prototype aims for fairness, transparency about its rule-based nature, privacy by avoiding personal-data collection, and accuracy by avoiding unsupported environmental claims. Recommendations are suggestions; people retain responsibility for decisions.

## Screenshots

Add screenshots of the home page, chat result, and MySQL record here after local deployment.

## Future scope

Replace the prototype method with a guarded AI service integration (such as IBM Granite), add multilingual support, better category matching, analytics that respect privacy, and authenticated administrator reporting.

# 🌱 Touch Grass API

**Touch Grass is an AI-powered application that encourages people to spend less time in front of screens and more time outdoors.**

The application generates personalized outdoor missions using a locally running AI model. Users can explore their missions through a web interface or interact with them through a REST API.

## ✨ Features

- **AI-generated missions:** Generate outdoor activities using a local Ollama model.
- **Configurable difficulty:** Choose between `EASY`, `MEDIUM`, and `HARD`.
- **Duration limits:** Request missions within a maximum duration.
- **Mission persistence:** Store missions in an H2 database.
- **Mission management:** List missions, retrieve individual missions, and mark them as completed.
- **Web interface:** Create and complete missions through a simple Thymeleaf interface.
- **REST API:** Access the main application features through HTTP endpoints.
- **Hexagonal architecture:** Separate business rules from infrastructure and external technologies.

## 🛠️ Tech Stack

| Technology | Purpose |
| --- | --- |
| Java 17 | Programming language |
| Spring Boot 4.1.1 | Application framework |
| Spring MVC | REST API and web controllers |
| Spring Data JPA | Database persistence |
| H2 Database | Local database |
| Thymeleaf | Server-rendered web interface |
| Jakarta Validation | Request validation |
| Ollama | Local AI model execution |
| Qwen3 4B | Mission content generation |
| Maven | Dependency management and build |

## 🏗️ Architecture

The project follows **Hexagonal Architecture (Ports and Adapters)** to separate business logic from external technologies.

```text
                    ┌──────────────────────┐
                    │   Inbound Adapters   │
                    │ REST API / Web UI    │
                    └──────────┬───────────┘
                               │
                    ┌──────────▼───────────┐
                    │   Application Layer  │
                    │      Use Cases       │
                    └──────────┬───────────┘
                               │
                    ┌──────────▼───────────┐
                    │     Domain Layer     │
                    │ Models and Ports     │
                    └──────┬─────────┬─────┘
                           │         │
                 ┌─────────▼──┐  ┌───▼────────────┐
                 │ H2 Adapter │  │ Ollama Adapter │
                 │ Persistence│  │ AI Generation  │
                 └────────────┘  └────────────────┘
```

The domain defines the application's core models and ports. Infrastructure adapters implement those ports for persistence and AI generation, while inbound adapters expose the use cases through HTTP.

This structure helps keep business rules independent of frameworks and infrastructure details.

## 🚀 Getting Started

### Prerequisites

Make sure you have installed:

- Java 17 or a compatible JDK.
- Git.
- Ollama.
- The Qwen3 4B model used by the application.

### 1. Clone the repository

```bash
git clone https://github.com/ArthurHebertt/Touch-grass-api.git
cd Touch-grass-api
```

### 2. Download the AI model

```bash
ollama pull qwen3:4b-q4_K_M
```

Make sure Ollama is running and the model is available locally.

The application uses the Ollama generation API at:

```text
http://localhost:11434/api/generate
```

### 3. Run the application

On Windows, use the Maven Wrapper:

```powershell
.\mvnw.cmd spring-boot:run
```

The application starts on:

```text
http://localhost:8080
```

### 4. Open the web interface

Visit:

```text
http://localhost:8080/missions
```

From the web interface, you can generate outdoor missions and mark them as completed.

## 🔌 REST API

The REST API is available under `/api/v1/missions`.

| Method | Endpoint | Description |
| --- | --- | --- |
| `POST` | `/api/v1/missions` | Generate and create a mission |
| `GET` | `/api/v1/missions` | Retrieve all missions |
| `GET` | `/api/v1/missions/{id}` | Retrieve a mission by its ID |
| `PATCH` | `/api/v1/missions/{id}/completion` | Mark a mission as completed |

### Create a mission

Example request:

```http
POST /api/v1/missions
Content-Type: application/json
```

```json
{
  "maxDurationMinutes": 30,
  "difficulty": "EASY"
}
```

The application requests mission content from the local AI model, validates the generated duration, and persists the mission.

### Complete a mission

```http
PATCH /api/v1/missions/{id}/completion
```

Replace `{id}` with the UUID of the mission you want to complete.

## 🗄️ Database

The application uses an H2 file-based database for local persistence.

The database URL is configured in `application.properties`:

```properties
spring.datasource.url=jdbc:h2:file:./data/touchgrassdb
spring.jpa.hibernate.ddl-auto=update
```

The database files are stored locally and excluded from Git.

For development, the H2 console is enabled at:

```text
http://localhost:8080/h2-console
```

The default JDBC URL is:

```text
jdbc:h2:file:./data/touchgrassdb
```

The H2 console is intended for local development, not production deployment.

## 🧪 Running Tests

Run the test suite with:

```powershell
.\mvnw.cmd test
```

To package the application:

```powershell
.\mvnw.cmd package
```

## 🌍 Why Touch Grass?

Technology is part of everyday life, but spending time away from screens matters too.

Touch Grass uses technology to encourage people to reconnect with the physical world. Instead of keeping users engaged with another endless digital feed, the application suggests practical outdoor activities they can complete in real life.

## 🤝 Why Open-Source AI Matters

Using a locally running AI model makes experimentation more accessible and gives developers greater control over their AI infrastructure.

By combining an open-source development approach with local AI inference, Touch Grass explores how AI can support healthier habits and real-world experiences.

## 🔮 Future Improvements

Potential future improvements include:

- More personalized mission generation.
- Additional mission categories and user preferences.
- Mission history and progress tracking.
- Improved automated test coverage.
- Deployment and production-ready configuration.

## 📄 License

See the repository for licensing information.

---

**Touch Grass API — Less scrolling, more exploring.** 🌱

Built with Java, Spring Boot, and local AI.

# 🐍 Snake Game (Java) – Maven + GitHub Actions CI/CD + Docker

This project is a classic **Snake Game** built using **Java Swing**, enhanced with:

* Modernized UI
* Obstacles on the board
* "Play Again" option after Game Over
* Maven project structure
* Automated JAR building using GitHub Actions
* Automated GitHub Release publishing
* **Docker containerization for consistent deployment**

This project demonstrates **core Java**, **Maven**, **Git**, **CI/CD automation**, and **Docker-based containerization**.

---

## 📌 Features

### 🎮 Game Features

* Smooth snake movement (arrow keys)
* Food spawning & score counting
* Random obstacles
* Game Over dialog with **Play Again**
* Clean, simple UI
* Persistent **High Score tracking**

### 🛠 Technical Features

* Built using **Maven (Packaging: JAR)**
* Automated CI/CD pipeline:

  * Maven build on tag push
  * Artifact upload
  * Automatic GitHub Release
* Docker containerization using **multi-stage build**
* Uses Java 17
* Cross-platform runnable JAR

---

## 📁 Project Structure

```
snake-game/
│── src/
│   ├── main/java/com/snakegame/
│   │      ├── GameFrame.java
│   │      ├── GamePanel.java
│   │      ├── HighScoreManager.java
│   │      ├── App.java
│   │
│   ├── test/java/...
│
│── target/ (generated)
│── pom.xml
│── Dockerfile
│── .github/workflows/release.yml
│── README.md
```

---

## 🚀 How to Run the Game

### ▶️ Run using JAR file

After build or release:

```
java -jar target/snake-game-1.0-SNAPSHOT.jar
```

If using Windows, double-click the JAR.

---

## 🧪 Running Locally

### 🔹 Build JAR manually:

```
mvn clean package
```

### 🔹 Run:

```
java -jar target/*.jar
```

---

## 🐳 Docker Integration

This project is containerized using Docker to ensure **consistent build and runtime environments**.

### 🔹 Build Docker Image

```
docker build -t snake-game .
```

### 🔹 Run Docker Container

```
docker run snake-game
```

⚠️ Note:
Since this is a **Java Swing GUI application**, the game window will not display inside the Docker container.
However, the container successfully executes the application, demonstrating proper containerization.

### 🔹 Multi-stage Docker Build

* Uses Maven image to build the project
* Uses lightweight Java image to run the JAR
* Reduces final image size

---

## 🔧 CI/CD Pipeline (GitHub Actions)

Workflow location:

```
.github/workflows/release.yml
```

### 🔄 Pipeline Steps

✔ Checkout repository
✔ Setup Java 17
✔ Build using Maven
✔ Generate JAR file
✔ Build Docker image
✔ Save Docker image as artifact
✔ Upload artifacts (JAR + Docker image)
✔ Create GitHub Release

---

### ▶️ Trigger Pipeline

Push a version tag:

```
git tag v1.0.0
git push origin v1.0.0
```

---

## 📦 Artifacts Generated

Each release contains:

* ✅ Executable JAR file
* ✅ Docker image (`.tar`)
* ✅ Automated GitHub release

---

## 🧩 Technologies Used

* **Java 17**
* **Maven**
* **Git & GitHub**
* **GitHub Actions**
* **Docker**
* **Swing (UI)**
* **CI/CD Automation**
* **Semantic Versioning**

---

## 🎯 Learning Outcomes

By building this project, I learned:

### 🔹 DevOps Concepts

* CI/CD pipelines
* GitHub Actions workflows
* Docker containerization
* Multi-stage builds
* Artifact management
* Release automation

### 🔹 Maven Concepts

* POM structure
* Dependency management
* Build lifecycle
* Executable JAR generation
* Maven plugins

### 🔹 Git/GitHub

* Version control
* Tag-based releases
* Repository structuring
* CI/CD integration

### 🔹 Java Development

* Swing UI
* Event-driven programming
* Game loop logic
* Object-oriented design
* File handling (High Score persistence)

---

## 📦 Final Output

* Fully working Snake Game
* Maven-built executable JAR
* Docker containerized application
* Automated CI/CD pipeline
* GitHub Releases with artifacts

---

## 👤 Author

**Mahek Mehra – 2025**

# 🐍 Snake Game (Java) – Maven Build + GitHub Actions CI/CD

This project is a classic **Snake Game** built using **Java Swing**, enhanced with:

- Modernized UI
- Obstacles on the board
- "Play Again" option after Game Over
- Maven project structure
- Automated JAR building using GitHub Actions
- Automated GitHub Release publishing

This project demonstrates **core Java**, **Maven**, **Git**, and **CI/CD automation**.

---

## 📌 Features

### 🎮 Game Features
- Smooth snake movement (arrow keys)
- Food spawning & score counting
- Random obstacles
- Game Over dialog with **Play Again**
- Clean, simple UI

### 🛠 Technical Features
- Built using **Maven (Packaging: JAR)**
- Automated CI/CD pipeline:
  - Maven build on tag push
  - Artifact upload
  - Automatic GitHub Release
- Uses Java 17
- Cross-platform runnable JAR

---

## 📁 Project Structure

```
snake-game/
│── src/
│   ├── main/java/com/snakegame/
│   │      ├── GameFrame.java
│   │      ├── GamePanel.java
│   │      ├── App.java
│   │     
│   ├── test/java/...
│
│── target/ (generated)
│── pom.xml
│── .github/workflows/release.yml
│── README.md
```

---

## 🚀 How to Run the Game

### **1. Run using JAR file**
After build or release:

```
java -jar target/snake-game-1.0-SNAPSHOT.jar
```

If using Windows, double-click the JAR.

---

## 🧪 Running Locally

### Build JAR manually:
```
mvn clean package
```

### Run:
```
java -jar target/*.jar
```

---

## 🔧 CI/CD Pipeline (GitHub Actions)

A workflow is stored in:

```
.github/workflows/release.yml
```

It performs:

✔ Checkout repository  
✔ Install Java  
✔ Build with Maven  
✔ Upload artifact  
✔ Create GitHub Release  
✔ Attach JAR to release  

Triggered when you push a tag like:

```
git tag v1.0.0
git push origin v1.0.0
```

---


## 🧩 Technologies Used

- **Java 17**
- **Maven**
- **Git & GitHub**
- **GitHub Actions**
- **Swing (UI)**
- **CI/CD Automation**
- **Semantic Versioning**

---

## 🎯 Learning Outcomes

By building this project, I learned:

### 🔹 **DevOps Concepts**
- Automation pipelines  
- GitHub Actions workflows  
- Artifact uploading/downloading  
- Release automation  
- Debugging CI/CD errors  

### 🔹 **Maven Concepts**
- POM structure  
- Managing dependencies  
- Build lifecycle  
- Generating executable JAR  
- Maven plugins  

### 🔹 **Git/GitHub**
- Branching & commits  
- Writing professional commit messages  
- Working with tags  
- Publishing releases  
- Repo structure best practices  

### 🔹 **Java Development**
- Swing UI  
- Event listeners  
- Game loop  
- Java object-oriented design  
- Packaging applications  

---

## 📦 Final Output

- A fully working Snake Game  
- A Maven-built runnable JAR  
- Fully automated CI/CD pipeline  
- Professional release publishing  

---

## 👤 Author

Mahek Mehra – 2025  

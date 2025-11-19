# Number Prediction Game (Java)

A simple **Number Prediction (Guessing) Game** built using Java. This project is suitable for internship submission and demonstrates core programming concepts such as loops, conditionals, user input validation, functions, and basic object‑oriented programming.

---

## 📌 Features

* Three difficulty levels: **Easy / Medium / Hard**
* Random number generation
* Input validation (prevents crashes on wrong input)
* Attempt counter and scoring system
* Menu‑driven interface
* Clean and simple Java code structure

---

## 📁 Project Structure

```
Number-Prediction-Game/
├─ src/
│  └─ com/internship/numberprediction/
│     ├─ Main.java
│     └─ Game.java
├─ README.md
├─ LICENSE
└─ .gitignore
```

---

## ▶️ How to Run the Project

### **1. Compile the Java files**

```
javac -d out src/com/internship/numberprediction/*.java
```

### **2. Run the game**

```
java -cp out com.internship.numberprediction.Main
```

---

## 🎮 Game Instructions

* Choose a difficulty level
* A secret random number will be generated
* Try to guess the number within the allowed attempts
* You’ll get hints: **Too high** or **Too low**
* Your final score depends on:

  * Difficulty level
  * Remaining attempts

---

## 🛠️ Technologies Used

* Java 8 or higher
* No external libraries required

---

## 🚀 Suggested Improvements

* Store highest score in a file
* Add JavaFX/Swing GUI
* Add sound effects
* Add multiplayer mode
* Create unit tests using JUnit

---

## 👨‍💻 Author

Your Name — Internship Project

---

## 📄 License (MIT)

This project is licensed under the MIT License. See **LICENSE** file for details.

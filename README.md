🧮 Java RPN Scientific Calculator with Stack Operations
========================================================

> 🚀 A fully functional scientific calculator using Stack-Based Reverse Polish Notation, built in Java, designed with Waterfall methodology, and developed in a collaborative software engineering environment as part of a university project.

* * *

📌 Overview
-----------

**StackBasedCalculator** is a fully-featured **Reverse Polish Notation (RPN)** scientific calculator developed as part of a team project for a university Software Engineering course. Built with Java and the **Waterfall development model**, this project demonstrates modular architecture, collaborative coding, and extensive testing.

### 📁 Project Highlights

* ✅ RPN (postfix) input processing
    
* 🧠 Stack-based operations and memory
    
* 🎨 GUI interface with calculator-like appearance
    
* 🧪 JUnit test suite for core components
    
* 📊 UML & Gantt-based planning
    
* 📌 Developed in a simulated real-world environment
    

* * *

🌍 Language Note
----------------

All **code comments and internal documentation** are written in **Italian**, as the project was developed during a group exam at the **University of Salerno (Italy)**.

Despite this, the **codebase follows international best practices**, with clear method names and class structures that make it easily understandable for global developers and recruiters.

* * *

💡 Features
-----------

### 🔢 Stack Operations

* `clear` – remove all elements
    
* `drop` – remove top element
    
* `dup` – duplicate top element
    
* `swap` – swap top two elements
    
* `over` – duplicate second-to-top element
    

### ➕ Arithmetic & Variables

* Basic operations: `+`, `-`, `*`, `/`
    
* 26 memory variables: `a` through `z`
    
    * `>x` – Load top of stack into variable `x`
        
    * `<x` – Push value from variable `x` onto the stack
        
    * `+x`, `-x` – Perform arithmetic with variable `x` and top of stack
        

### 🧮 Advanced Capabilities

* Complex number support
    
* Rich exception handling (stack underflow, invalid operations, etc.)
    
* GUI with custom calculator fonts
    

* * *

🧠 Development Process
----------------------

> Developed over 2 months, this project followed a strict **Waterfall model**, simulating a professional software lifecycle.

1. ✅ **Requirements Analysis**
    
2. 📅 **Gantt Chart Planning**
    
3. 📐 **Design using UML**
    
4. 💻 **Development in Java**
    
5. 🧪 **JUnit Testing**
    
6. 🚀 **Final Release and Live Demo**
    

> All milestones and deadlines were met — reflecting a real-world agile workflow within an academic structure.

* * *

🧪 Testing
----------

Comprehensive **unit testing** was performed using **JUnit**, ensuring correctness of:

* Stack operations
    
* Variable manipulation
    
* Complex number calculations
    

Test classes are located in:

```
test/java/AH/gruppo14/stackbasedcalculator/
```

* * *

🧱 Project Structure
--------------------

```
📦 StackBasedCalculator
├── 📁 docs
│   ├── 1 - Requirements Elicitation and Analysis.pdf
│   ├── 2 - Use Case.pdf
│   ├── 3 - Activity Diagram.pdf
│   ├── 4 - Class Diagram.pdf
│   └── 5 - User Manual.pdf
├── 📁 resources/fonts
│   ├── Calculator.ttf
│   └── LEDCalculator.ttf
├── 📁 src/main/java
│   └── AH/gruppo14/stackbasedcalculator/
│       ├── BaseView.java, Buttons.java, CalculatorView.java
│       ├── StackCalculator.java, StackBasedCalculator.java
│       ├── StackCalculatorController.java
│       ├── CalculatorStack.java, CalculatorVariables.java, Complex.java
│       ├── StackView.java, VariablesView.java, SystemInfo.java
│       └── 📁 Eccezioni (Custom Exceptions)
│           └── StackVuotoException.java, StackPienoException.java, etc.
├── 📁 test/java/AH/gruppo14/stackbasedcalculator/
│   └── CalculatorStackTest.java, ComplexTest.java, etc.
└── pom.xml, .gitignore, README.md
```

* * *

💻 User Interface Snapshot
---------------------------
![image](https://github.com/user-attachments/assets/aa89e965-6643-4241-91af-8de651fe25b8)

* * *

👥 Team 14 – University of Salerno
----------------------------------

* [@apiantonio](https://github.com/apiantonio)
    
* [@BeneCelano](https://github.com/BeneCelano)
    
* [@francescopiocirillo](https://github.com/francescopiocirillo) (👑 Team Leader)
    
* [@alefaso-lucky](https://github.com/alefaso-lucky)
    
* * *

📈 SEO Tags
-----------

```
java rpn calculator, reverse polish notation java, stack based calculator,
scientific calculator java, java postfix calculator, java gui calculator,
university software engineering project, waterfall model java,
rpn calculator github, calculator with stack java
```

* * *

🚀 Getting Started
------------------

1. Clone the repo
    
    ```bash
    git clone https://github.com/yourusername/StackBasedCalculator.git
    ```
    
2. Open in your preferred IDE (NetBeans, VS Code, IntelliJ)
    
3. Run `DummyMain.java` to launch the application
    

* * *

📄 License
----------

This project is licensed under the **MIT License**, a permissive open-source license that allows anyone to use, modify, and distribute the software freely — as long as credit is given and the original license is included.

> In plain terms: **use it, build on it, just don’t blame us if something breaks**.

> ⭐ Like what you see? Consider giving the project a star!

* * *

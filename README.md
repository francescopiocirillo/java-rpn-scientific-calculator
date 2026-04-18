🧮 Java RPN Scientific Calculator with Stack Operations
========================================================

🚀 A fully functional scientific calculator using Stack-Based Reverse Polish Notation, built in Java, designed with Waterfall methodology, and developed in a collaborative software engineering environment as part of a university project.

> Demonstrated skills in Java development, GUI design with JavaFX, stack-based algorithm implementation, Waterfall software engineering practices, UML modeling, and unit testing with JUnit.

* * *

📸 User Interface Snapshot
---------------------------
![image](https://github.com/user-attachments/assets/aa89e965-6643-4241-91af-8de651fe25b8)

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
    

> All milestones and deadlines were met, reflecting a real-world agile workflow within an academic structure.

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

📋 Documentation
----------------

You can find documentation and technical reports inside the `docs/` folder, including:

* **Requirements Elicitation and Analysis Report**: Contains the process of gathering and analyzing the project requirements, outlining the needs and expectations of stakeholders.
    
* **Use Case Diagrams**: Describe specific scenarios in which the system will be used, detailing how users interact with the system to achieve a goal.
    
* **Activity Diagrams**: Represent workflows and processes within the system, showing the sequence of activities and decision points.
    
* **Class Diagram**: Illustrates the system’s structure, highlighting classes, attributes, methods, and the relationships between different entities in the system.
    
* **User Manual**: Provides instructions and guidance for end-users on how to operate and interact with the system effectively.
    

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

👥 Team 14 – University of Salerno
----------------------------------

* [@apiantonio](https://github.com/apiantonio)
    
* [@BeneCelano](https://github.com/BeneCelano)
    
* [@francescopiocirillo](https://github.com/francescopiocirillo) (👑 Team Leader)
    
* [@alefaso-lucky](https://github.com/alefaso-lucky)
    
* * *


🚀 How to Run Locally
------------------

1. Clone the repo
    
    ```bash
    git clone https://github.com/francescopiocirillo/java-rpn-scientific-calculator.git
    ```
    
2. Open in your preferred IDE (NetBeans, VS Code, IntelliJ)
    
3. Run `DummyMain.java` to launch the application

### 🧩 Development Environment

- ☕ Java version: **23.0.1**
- 🎭 JavaFX SDK version: **24.0.1**
    

* * *

📬 Contacts
-----------

✉️ For questions or suggestions, feel free to contribute or report any corrections! Open an **Issue**!🚀

* * *

📈 SEO Tags
-----------

```
Java RPN Calculator, Reverse Polish Notation Calculator, Stack-based Calculator Java, Java Scientific Calculator, RPN Scientific Calculator, Stack operations calculator, Waterfall methodology software, Collaborative Java project, JUnit testing in Java, UML design in Java, Stack-based calculator features, Java complex number calculator, GUI scientific calculator Java, RPN calculator with variables, Java programming university project, University of Salerno Java project, Stack-based architecture, Calculator with memory variables, Exception handling in Java, Postfix calculator Java, Calculator development team project, Software engineering Java project, Open-source scientific calculator, Java programming for beginners, Java unit testing, StackVuotoException Java, Java StackOverflowException handling, Reverse Polish Notation stack operations, RPN calculator GUI interface, Java Waterfall methodology project, Collaborative coding Java, Java StackCalculator project, University project with UML and Gantt

```

* * *

📄 License
----------

This project is licensed under the **MIT License**, a permissive open-source license that allows anyone to use, modify, and distribute the software freely, as long as credit is given and the original license is included.

> In plain terms: **use it, build on it, just don’t blame us if something breaks**.

> ⭐ Like what you see? Consider giving the project a star!

* * *

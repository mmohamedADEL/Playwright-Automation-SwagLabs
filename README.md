
# 🎭 Playwright Automation Framework for SwagLabs

---

## 🚀 Overview
Welcome to the **Playwright-based automation framework** for the **SwagLabs** application!  
This framework uses **Playwright with Java** for robust UI automation, integrated with essential tools and features:

- **Maven** for dependency & build management  
- **Jenkins (CI/CD)** for automated test pipelines  
- **Allure** for beautiful, detailed test reports  
- **Log4j** for advanced logging capabilities  
- **JSON** files for isolated, maintainable test data  

---

## 🛠 Prerequisites
Before you get started, make sure you have the following installed:

- [Java JDK 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)  
- [Maven](https://maven.apache.org/install.html)  
- [Git](https://git-scm.com/downloads)  
- [Node.js](https://nodejs.org/en/) (required by Playwright)  
- Internet connection to download dependencies  

---

## 📥 How to Install & Setup

1. **Clone the repository**  
```bash
git clone https://github.com/mmohamedADEL/Playwright-Automation-SwagLabs.git
cd Playwright-Automation-SwagLabs
```
2. **Install dependencies**  
Run Maven to download all dependencies and build the project:  
```bash
mvn clean install
```
3. **Run tests**
   
Execute tests using Maven:
```bash
mvn clean install
```
4. **Generate allure report**
```bash
mvn allure:serve
```
---

## 🗂 Project Structure

```
├───main
│   ├───java
│   │   ├───factory
│   │   │       PageFactory.java
│   │   │
│   │   ├───pages
│   │   │       CartPage.java
│   │   │       CheckoutPage.java
│   │   │       FinishPage.java
│   │   │       HomePage.java
│   │   │       LoginPage.java
│   │   │       OverviewPage.java
│   │   │
│   │   └───utilities
│   │           DataUtility.java
│   │           LogUtility.java
│   │           Utility.java
│   │
│   └───resources
│           Allure.properties
│           Log4j2.properties
│
└───test
    ├───java
    │   ├───Listeners
    │   │       InvokedMethodListenersClass.java
    │   │       ITestListenerClass.java
    │   │
    │   └───Tests
    │           OverviewTest.java
    │
    └───resources
        └───TestData
                CheckOutData.json
                confirmation_msg.json
                Environment.properties
                error_msg.json
                LoginData.json
```


---

## ✨ Key Features
- ⚡ **Playwright Java bindings** for fast and reliable UI automation  
- 📦 **Maven** for easy dependency management  
- 🤖 **Jenkins** CI/CD pipeline for continuous testing  
- 📊 **Allure reports** with beautiful test visualization  
- 📝 **Log4j** for comprehensive logging  
- 📂 **JSON-based test data** for clear and maintainable test inputs  
- 🎧 **Listeners** for enhanced test lifecycle handling  

---

## 📌 Notes
- This framework is focused on **Playwright** implementation.  
- For **Selenium** version, check the other repository:  
  [SwagLabs Selenium Automation Framework](https://github.com/mmohamedADEL/SwagLabs_AutomationFramework)  
- Both frameworks share a **Maven** base and utilize **similar data management strategies** for consistency.


---

## 👤 Author
**Mohamed Adel**  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Mohamed%20Adel-blue?style=flat-square&logo=linkedin)](https://www.linkedin.com/in/mohamed-adel-elbaz-79239a272/)

---

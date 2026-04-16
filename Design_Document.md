#  Design Document

---

##  Introduction

This project is a Selenium-based automation framework developed using Java and TestNG to automate a demo banking application.
The objective is to build a reusable, scalable, and maintainable test automation framework**.

---

##  Objectives

* Automate end-to-end banking workflows
* Implement the Page Object Model (POM) design pattern
* Ensure reusability and maintainability of test scripts
* Generate reports and capture screenshots on failures

---

##  Technology Stack

* Language: Java
* Automation Tool: Selenium WebDriver
* Testing Framework: TestNG
* Build Tool: Maven
* Reporting: ExtentReports
* Driver Management: WebDriverManager

---

##  Framework Architecture

### Page Object Model (POM)

* Each page is represented by a separate class
* Locators and actions are defined inside page classes
* Test classes interact only with page methods
* Improves code readability and maintainability

---


## Project Structure
```
BankingAutomationFramework
│
├── src/main/java
│   ├── com.srm.base
│   │   ├── BasePage.java
│   │   └── BaseTest.java
│   │
│   ├── com.srm.listeners
│   │   └── TestListener.java
│   │
│   ├── com.srm.pages
│   │   ├── LoginPage.java
│   │   ├── HomePage.java
│   │   ├── NewCustomerPage.java
│   │   ├── NewAccountPage.java
│   │   ├── TransactionPage.java
│   │   ├── FundTransferPage.java
│   │   └── ReportsPage.java
│   │
│   ├── com.srm.utils
│   │   ├── ConfigReader.java
│   │   ├── ExcelUtil.java
│   │   ├── ScreenshotUtil.java
│   │   └── ExtentManager.java
│
├── src/main/resources
│   ├── config.properties
│   └── LoginData.xlsx
│
├── src/test/java
│   └── com.srm.tests
│       ├── LoginTest.java
│       ├── LogoutTest.java
│       ├── ValidationTest.java
│       ├── CustomerTest.java
│       ├── AccountTest.java
│       ├── TransactionTest.java
│       ├── FundTransferTest.java
│  
│
├── reports/
├── screenshots/
│
├── testng.xml
├── pom.xml

```

\# DESIGN DOCUMENT



\## 1. Introduction



This project is a Selenium-based automation framework developed using Java and TestNG to automate a demo banking application. The goal is to create a reusable, scalable, and maintainable automation framework.



\---



\## 2. Objectives



\* Automate end-to-end banking workflows

\* Implement Page Object Model design pattern

\* Ensure reusability and maintainability

\* Generate reports and screenshots on failure



\---



\## 3. Technology Stack



\* Language: Java

\* Automation Tool: Selenium WebDriver

\* Testing Framework: TestNG

\* Build Tool: Maven

\* Reporting: ExtentReports

\* Driver Management: WebDriverManager



\---



\## 4. Framework Architecture



\### Page Object Model (POM)



\* Each page is represented by a separate class

\* Locators and actions are encapsulated inside page classes

\* Test classes interact only with page methods



\---



\## 7. Wait Strategy



\* WebDriverWait used for dynamic elements

\* No Thread.sleep used



\---








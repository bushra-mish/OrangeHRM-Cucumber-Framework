# OrangeHRM Cucumber BDD Framework

[![Java](https://img.shields.io/badge/Java-17-blue)](https://openjdk.org/)
[![Selenium](https://img.shields.io/badge/Selenium-4.27.0-green)](https://www.selenium.dev/)
[![Cucumber](https://img.shields.io/badge/Cucumber-7.18.1-brightgreen)](https://cucumber.io/)

A **Behavior-Driven Development** test automation framework built with Java, Selenium WebDriver, and Cucumber — targeting the public **OrangeHRM demo application** as the system under test.

> **Why this project?** Built to demonstrate clean automation architecture: Page Object Model, reusable utilities, data-driven testing via Excel, video recording, and encapsulation of configuration — all following industry best practices.

---

## 🏗️ Architecture

```
                 BaseClass
              (WebDriver lifecycle)
                    |
             PageInitializer
          (lazy page object init)
                    |
              CommonMethods
        (all reusable Selenium actions)
              /          \
        Page Objects    Step Definitions
     (@FindBy locators)  (Gherkin glue code)
```

**Design principles:**
- **Page Object Model** — each page is a class; locators live in `@FindBy` annotations
- **Inheritance chain** — `BaseClass → PageInitializer → CommonMethods → Steps` gives every step access to `driver` and utility methods with zero boilerplate
- **Composition over inheritance** for page objects — they reference `BaseClass.driver` directly, keeping them decoupled from the step layer
- **Encapsulated config** — `ConfigsReader` wraps a private `Properties` object, exposing only `getProperty()` and `readProperties()`

---

## 📁 Project Structure

```
src/
├── test/java/com/qa/hrm/
│   ├── pages/          Page Object classes (Selenium PageFactory)
│   ├── runners/        JUnit Cucumber test runners
│   ├── steps/          Cucumber step definitions
│   ├── testbase/       BaseClass & PageInitializer
│   └── utils/          CommonMethods, ConfigsReader, ExcelUtility, VideoRecorder
├── test/resources/
│   ├── configs/        Configuration template + cucumber.properties
│   ├── features/       Gherkin .feature files (8 scenarios)
│   └── testdata/       Excel data files for data-driven tests
```

---

## 🚀 Quick Start

### Prerequisites
- **Java 17+**
- **Maven 3.8+**
- **Chrome** (or Firefox)

### Setup
```bash
# 1. Clone
git clone <repo-url>
cd OrangeHRM-Cucumber-Framework

# 2. Create your config file
cp src/test/resources/configs/configuration.properties.template \
   src/test/resources/configs/configuration.properties

# 3. Fill in your credentials (or use the OrangeHRM demo defaults)
#    browser=chrome
#    url=https://opensource-demo.orangehrmlive.com
#    username=Admin
#    password=admin123

# 4. Run
mvn test
```

### Run specific suites
```bash
mvn test -Dtest=RegressionRunner          # all @regression tags
mvn test -Dcucumber.filter.tags="@smoke"  # smoke only
mvn test -Dtest=FailedRunner              # re-run failures
```

---

## 🎥 Features

| Feature | Description |
|---------|-------------|
| **BDD with Cucumber** | Gherkin syntax — business-readable scenarios |
| **Page Object Model** | Clean separation of locators from test logic |
| **Data-driven testing** | Excel integration via Apache POI for bulk test data |
| **Video recording** | Every scenario recorded via Monte Screen Recorder |
| **Screenshot on failure** | Automatic capture attached to Cucumber reports |
| **Re-run failed tests** | `FailedRunner` picks up `target/failed.txt` |
| **Config encapsulation** | `ConfigsReader` + gitignored real properties file |
| **Cross-browser** | Chrome and Firefox via config switch |

---

## 🔧 Configuration

Edit `configuration.properties` (not committed — gitignored):

```properties
browser=chrome
url=https://opensource-demo.orangehrmlive.com
username=Admin
password=admin123
```

---

## 📊 Reporting

Cucumber HTML + JSON reports auto-generated in `target/`. Videos in `target/videos/`.

---

## 📝 License

This is a personal portfolio project — free to use and adapt.

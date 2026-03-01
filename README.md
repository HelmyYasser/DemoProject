# DemoProject

Java-based UI test automation project built with **Selenium WebDriver** + **TestNG**, with **Allure** reporting and **Log4j2** logging. :contentReference[oaicite:0]{index=0}

---

## Tech Stack

- **Java 21** :contentReference[oaicite:1]{index=1}  
- **Maven** (project build tool via `pom.xml`) :contentReference[oaicite:2]{index=2}  
- **Selenium WebDriver** :contentReference[oaicite:3]{index=3}  
- **TestNG** :contentReference[oaicite:4]{index=4}  
- **Allure Report (TestNG integration)** :contentReference[oaicite:5]{index=5}  
- **Log4j2** :contentReference[oaicite:6]{index=6}  
- Utilities: `commons-io`, `json-path`, `json-simple` :contentReference[oaicite:7]{index=7}  

---

## Project Layout (high level)

Common folders you’ll see in this repo:

- `src/` – source code (tests, pages, utils, etc.)
- `test-output/` – TestNG execution output (ignored in git) :contentReference[oaicite:8]{index=8}
- `allure-report/` – generated Allure HTML report (ignored in git) :contentReference[oaicite:9]{index=9}
- `pom.xml` – Maven config and dependencies :contentReference[oaicite:10]{index=10}

> Note: `test-output` and `allure-report` are intentionally ignored to keep the repo clean. :contentReference[oaicite:11]{index=11}

---

## Prerequisites

- **JDK 21**
- **Maven 3.x**
- (Optional) **Allure Commandline** if you want to generate/serve reports locally  
  - Allure TestNG docs: :contentReference[oaicite:12]{index=12}

---

## Setup

Clone the repo:

```bash
git clone https://github.com/HelmyYasser/DemoProject.git
cd DemoProject

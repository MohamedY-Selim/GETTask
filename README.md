# Codenbox Automation Lab Testing

This project automates the registration and login cycles of the Codenbox Automation Lab website using Selenium WebDriver and generates Allure reports to track the test results.

## Project Overview

This project is designed to:

- Automate the registration and login process on the Codenbox Automation Lab website.
- Use Selenium WebDriver to interact with web elements and perform the required actions.
- Generate detailed Allure reports to monitor and track the results of the test cases.

## Project Structure

- `src/test/java`: Contains the test cases written using Selenium WebDriver.
- `pom.xml`: Maven configuration file that manages dependencies, plugins, and build configuration.
- `allure-results`: Directory where the Allure test results are stored after running the tests.
- `allure-report`: Directory where the Allure report is generated.

## Setup Instructions

### Prerequisites

Before you can run the tests, ensure you have the following installed on your system:

- **Java (version 22 or later)**: You can install it from Oracle's official website or use a package manager like Homebrew (`brew install openjdk@22`).
- **Maven**: Download and install Maven from the official website or via a package manager like Homebrew (`brew install maven`).
- **Allure Commandline**: Install Allure using Homebrew (`brew install allure`).

### Cloning the Repository

To clone this repository to your local machine, run the following command:

```bash
git clone https://github.com/MohamedY-Selim/GETTask.git
cd GETTask
```

### Running the Tests
To run the test cases, use the following Maven command:

```bash
mvn clean test
```
This will execute all the test cases and generate the test results in the allure-results directory.


### Generating the Allure Report
After running the tests, generate the Allure report using the following command:

```bash
allure serve allure-results
```
This command will start a local server and open the Allure report in your default web browser, allowing you to review the test results interactively.

### Continuous Integration with GitHub Actions
This project includes a GitHub Actions workflow that:

Runs the tests on every push to the main or master branches.
Generates an Allure report.

### Limitations
The current implementation only covers the registration and login cycles. Additional test cases might be needed for full coverage.
Ensure that the allure-results directory is not empty after the test execution; otherwise, the report generation will fail.

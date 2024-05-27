# Selenium Dev Page Test Suite

## Description

This project is a showcase of the capabilities of Java and Selenium. It is designed to test a number of pages on the Selenium Dev website.

## Installation

This project uses Maven for dependency management. To install the project, follow these steps:

1. Clone the repository: `git clone https://github.com/hypoflex/javaSelenium.git`
2. Navigate to the project directory: `cd javaSelenium`
3. Install the dependencies: `mvn install`

## Usage

To run the tests, execute the following command in the project directory:

```bash
mvn test -f pom.xml 
```

The `pom.xml` will use the defined `SuiteXML` of **TestNG** found in `/config/testng.xml`

You can however run the suite just with **TestNG** if so desired.

For this we recommend to use IntelliJ.
- Within IntelliJ create a new run configuration pointing to the suite file found in `/config/testng.xml`.
- next run the configuration using the play button in the top right.

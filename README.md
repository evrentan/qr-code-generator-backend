# QR Code Generator BackEnd
A QR Code Generator BackEnd application implemented in Java 17 using Zxing barcode processing library.

QR Code Generator Backend serves on a [Heroku][heroku-reference] instance in production from the [QR Code Generator Backend End-Point][qr-code-generator-backend-endpoint].

## Table of Contents

1. [How to Contribute](#how-to-contribute)
2. [Credits](#credits)
3. [Requirements](#requirements)
4. [Coding Standards](#coding-standards)
5. [Version Control Standards](#version-control-standards)
6. [Running the Application Locally](#running-the-application-locally)
7. [Running the Application in Docker](#running-the-application-in-docker)
8. [Run Actuator](#run-actuator)
9. [Run Swagger UI](#run-swagger-ui)
10. [Extra Notes](#extra-notes)
11. [Copyright](#copyright)

## How to Contribute

For the contributor covenant to this project, please check the Code of Conduct file.

[![Contributor Covenant][contributor]](CODE_OF_CONDUCT.md)

## Credits

Below you can find the names of the contributors to this project;

- [Evren Tan][evren-tan-github]
- [M. Said Gurbuz][shortlymsg-github]
- [Ujwal Kumar][ujwal-kumar-github]

## Requirements

For building and running the application belows are required;

- [Spring Boot 2.6.7][spring-boot-version]
- [JDK 17][java-version]
- [Gradle 7.3 or above][gradle-version]
- [Zxing 3.5.0 or above][zxing]

## Coding Standards

Below coding standards should be followed within the project;

- Javadoc should be written for each class & method. @author, @since annotations should be added while adding or updating the javadoc
- General code structure should be followed while adding or refactoring classes.

## Version Control Standards

Below version control standards should be followed within the project;

- Feature enhancements or defect fixes should not be committed to main branches, they should be coded in feature or fix branches.
- Issues should be created for each feature or fix in the [QR Code Generator Workspace GitHub Repository Project][qr-code-generator-workspace-github].
- Pull request (PR) should be created for each feature/fix branch to main branches.
- While creating a PR "feature:", "fix:" or "doc:" prefix should be used to identify the PR type.
- PRs should be linked with a valid issue in the [QR Code Generator Workspace GitHub Repository Project][qr-code-generator-workspace-github].

## Running the application locally

Application can be run with [QrCodeGeneratorBackendApplication][qr-code-generator-manager-main-class] class.

Alternatively you can use the [Spring Boot Gradle plugin][spring-boot-gradle-plugin] like so:

```shell
gradle clean build
gradle bootRun
```

## Running the Application in Docker

Application can be run in Docker. [Dockerfile](Dockerfile) in the project root folder is the configuration file for Docker build.

```shell
docker build -t qr-code-generator:1.0.0 --build-arg APP_JAR=qr-code-generator-backend-1.0.0.jar .
docker run -p 8081:8081 --name QrCodeGenerator qr-code-generator:1.0.0
```
Note that you can specify the name of the APP_JAR argument based on the jar file that is generate by gradle. If the argument is not provided, it will pick the default name specified in the Dockerfile.

## Run Actuator

[Spring Boot Actuator][spring-boot-actuator] can be reached from [local url for Actuator][local-actuator].

Only health and caches endpoints are enabled by default. Configuration can be updated within the "actuator" section of the related application.properties file.

## Run Swagger UI
[Swagger UI][swagger-ui] can be reached from [local url for Swagger UI][local-swagger-ui] and [production url for Swagger UI][production-swagger-ui].

## Extra Notes

* The module can be booted with Spring Cloud Config Server or directly within the application. In order to boot the project within itself, enable the properties in application.properties file and disable bootstrap.properties file.

## Copyright

GNU General Public License v3.0
Permissions of this strong copyleft license are conditioned on making available complete source code of licensed works and modifications, which include larger works using a licensed work, under the same license. Copyright and license notices must be preserved. Contributors provide an express grant of patent rights.
Please check the [LICENSE](LICENSE) file for more details.

[evren-tan-github]: https://github.com/evrentan
[qr-code-generator-backend-endpoint]: https://qr-code-generator-backend.herokuapp.com/
[spring-boot-version]: https://spring.io/blog/2022/04/21/spring-boot-2-6-7-available-now
[java-version]: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
[gradle-version]: https://gradle.org/releases/
[contributor]: https://img.shields.io/badge/Contributor%20Covenant-2.1-4baaaa.svg
[qr-code-generator-workspace-github]: https://github.com/evrentan/qr-code-generator-workspace
[qr-code-generator-manager-main-class]: src/main/java/evrentan/qrcodegenerator/qrcodegeneratorbackend/spring/spring/QrCodeGeneratorBackendApplication.java
[spring-boot-gradle-plugin]: https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/
[spring-boot-actuator]: https://spring.io/guides/gs/actuator-service/
[local-actuator]: http://localhost:8082/actuator
[zxing]: https://github.com/zxing/zxing
[swagger-ui]: https://swagger.io/tools/swagger-ui/
[local-swagger-ui]: http://localhost:8081/swagger-ui/index.html
[production-swagger-ui]: https://qr-code-generator-backend.herokuapp.com/swagger-ui/index.html
[heroku-reference]: https://heroku.com
[shortlymsg-github]: https://github.com/ShortlyMsg
[ujwal-kumar-github]: https://github.com/ujwalkumar1995
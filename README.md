## gradle-multiple-project [![Build Status](https://travis-ci.org/Allali84/gradle-multiple-project.svg)](https://travis-ci.org/Allali84/gradle-multiple-project)

Demo of gradle multi module project and clean architecture with Kotlin (JDK11)

### Tasks
 * `clean build`: clean and buil the project.
 * `gradle-multiple-project:spring-app:bootRun`: run the Spring App example (configured with Spring Data and H2 memory DB).
 * To run the Manual App example (configured with In memory DB (Map)), you can run the main class of the module "manual-app".
 
### TODO
 * Add gradle configuration to execute the manual app example
 * Add Unit tests
 * Add end to end tests
 * Update the WS config module to be runnable
 * Add Jigsaw feature

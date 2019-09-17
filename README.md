## gradle-multiple-project [![Build Status](https://travis-ci.org/Allali84/gradle-multiple-project.svg)](https://travis-ci.org/Allali84/gradle-multiple-project)

Demo of gradle multi module project and clean architecture with Kotlin (JDK11)

### clean and build the project
 * `gradle clean build`
##### run the Spring App example configured with Spring Data and H2 memory DB
 * `gradle gradle-multiple-project:spring-app-back-jpa:bootRun`
##### run the Spring App example configured with Spring Rest Template to consume Data from extern URL (Mock Server)
 * `gradle gradle-multiple-project:spring-app-back-ws:bootRun`
##### run the Manual App example (configured with In memory DB (Map))
 * `gradle gradle-multiple-project:manual-app:run`

### Project Architecture
    .
    ├── core                        # Project core (All the business here)
    │   ├── usescase                # The business actions/logic
    │   └── entities                # The domain objects
    │
    |── Adapters                    # Retrieve and store data from and to a number of sources (database, network devices, file system, 3rd parties, and so on.)
    │   ├── in-memory-hazelcast     # Example : In memory with hazelcast
    │   ├── in-memory-simple        # Example : Simple In memory with map
    │   ├── spring-rest-template    # Example : Spring Rest Template thats consume an externe URL
    │   └── spring-jpa              # Example : Spring Data (H2 Databse)
    │
    |── Config                      # The config folder thats put everything together
    │   ├── manual-config           # Configure the manual adapter (in-memory-simple)
    │   ├── spring-config-jpa       # Configure the Spring JPA adapter (spring-jpa)
    │   └── spring-config-ws        # Configure the Spring Rest Template adapter (spring-rest-template)
    │
    └── application                 # The applications can be used as front (Web, Client, batch ...)
        ├── manual-app              # Example of console App thats use the "manual-config" config
        ├── spring-app-back-jpa     # Example of Spring Rest App thats use the "spring-config-jpa" config
        └── spring-app-back-ws      # Example of Spring Rest App thats use the "spring-config-ws" config    
    
#### Clean architecture
![alt text](https://cdn-media-1.freecodecamp.org/images/lbexLhWvRfpexSV0lSIWczkHd5KdszeDy9a3 "Our clean Architecture")

Source and credit: Mattia Battiston, under CC BY 4.0, https://github.com/mattia-battiston/clean-architecture-example
 
 
### TODO
 * Add Unit tests
 * Add end to end tests

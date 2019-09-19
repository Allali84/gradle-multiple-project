rootProject.name = "gradle-multiple-project"
include("entities")
include("usescase")
include("in-memory-hazelcast")
include("in-memory-simple")
include("spring-jpa")
include("spring-rest-template")
include("manual-config")
include("spring-config-jpa")
include("spring-config-ws")
include("manual-app")
include("spring-app-back-jpa")
include("spring-app-back-ws")
include("graphql-app-back-jpa")
include("graphql-app-back-in-memory")

project(":entities").projectDir = File("core/entities")
project(":usescase").projectDir = File("core/usescase")
project(":in-memory-hazelcast").projectDir = File("adapters/in-memory-hazelcast")
project(":in-memory-simple").projectDir = File("adapters/in-memory-simple")
project(":spring-jpa").projectDir = File("adapters/spring-jpa")
project(":spring-rest-template").projectDir = File("adapters/spring-rest-template")
project(":manual-config").projectDir = File("config/manual-config")
project(":spring-config-jpa").projectDir = File("config/spring-config-jpa")
project(":spring-config-ws").projectDir = File("config/spring-config-ws")
project(":manual-app").projectDir = File("application/manual-app")
project(":spring-app-back-jpa").projectDir = File("application/spring-app-back-jpa")
project(":spring-app-back-ws").projectDir = File("application/spring-app-back-ws")
project(":graphql-app-back-jpa").projectDir = File("application/graphql-app-back-jpa")
project(":graphql-app-back-in-memory").projectDir = File("application/graphql-app-back-in-memory")
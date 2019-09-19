
dependencies {
	implementation(project(":entities"))
	implementation(project(":usescase"))
	implementation(project(":manual-config"))
	implementation("com.graphql-java:graphql-spring-boot-starter")
	implementation("com.graphql-java:graphiql-spring-boot-starter")
	implementation("com.graphql-java:graphql-java-tools")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}


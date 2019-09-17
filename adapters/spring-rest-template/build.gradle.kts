
dependencies {
	implementation(project(":usescase"))
	implementation(project(":entities"))
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework:spring-web")
	implementation("com.fasterxml.jackson.core:jackson-databind")
	implementation("org.mock-server:mockserver-netty")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("javax.validation:validation-api")
}
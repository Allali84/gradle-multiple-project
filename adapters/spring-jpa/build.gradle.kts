
dependencies {
	implementation(project(":usescase"))
	implementation(project(":entities"))
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("javax.validation:validation-api")
	implementation("com.h2database:h2")
}
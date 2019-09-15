
dependencies {
	implementation(project(":usescase"))
	implementation(project(":in-memory-simple"))
	implementation(project(":in-memory-hazelcast"))
	implementation(project(":spring-jpa"))
	implementation(project(":spring-rest-template"))
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

tasks.bootJar {
	enabled = false
}

tasks.jar {
	enabled = true
}

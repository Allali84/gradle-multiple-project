
dependencies {
	implementation(project(":usescase"))
	implementation(project(":spring-rest-template"))
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

tasks.bootRun {
	enabled = false
}
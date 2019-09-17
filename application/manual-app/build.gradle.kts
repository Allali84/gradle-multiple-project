
dependencies {
	implementation(project(":entities"))
	implementation(project(":usescase"))
	implementation(project(":manual-config"))
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}


plugins {
	application
}

application {
	mainClassName = "com.allali84.console.MainKt"
}
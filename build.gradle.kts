import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("io.spring.dependency-management") version "1.0.8.RELEASE"
	id("org.springframework.boot") version "2.1.8.RELEASE" apply false
	kotlin("jvm") version "1.3.50" apply false
	kotlin("plugin.spring") version "1.3.50" apply false
	java
}

java {
	sourceCompatibility = JavaVersion.VERSION_11
	targetCompatibility = JavaVersion.VERSION_11
}

defaultTasks("assemble")

allprojects {
	group = "com.allali84"
	version = "0.0.1-SNAPSHOT"

	repositories {
		mavenCentral()
	}

	tasks.forEach {
		if (it.name == "bootJar") {
			it.enabled = false
		}
		if (it.name == "jar") {
			it.enabled = false
		}
	}
}

subprojects {

	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "kotlin")
	if (name == "spring-jpa" || name == "spring-rest-template" || name == "config" || name == "spring-app" || name == "manual-app") {
		apply(plugin = "org.springframework.boot")
		apply(plugin = "org.jetbrains.kotlin.plugin.spring")
	}

	dependencyManagement {
		dependencies {
			imports {
				mavenBom("org.springframework.cloud:spring-cloud-dependencies:Greenwich.RELEASE")
			}
			dependencySet("io.swagger:1.5.12") {
				//entry("swagger-annotations") its included in swagger-jaxrs
				entry("swagger-jaxrs")
			}
			dependencySet("org.elasticsearch:6.2.1") {
				entry("elasticsearch")
				entry("transport")
				entry("elasticsearch-rest-client")
				entry("elasticsearch-rest-high-level-client")
			}
			dependency("javax.ws.rs:javax.ws.rs:2.1")
			dependency("javax:javaee-api:8.0.1")
			dependency("javax.validation:validation-api:2.0.0.Final")
			dependency("com.hazelcast:hazelcast:3.12.2")
		}
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}
}


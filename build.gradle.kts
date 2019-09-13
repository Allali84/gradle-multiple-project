
plugins {
	id("io.spring.dependency-management") version "1.0.8.RELEASE"
}

defaultTasks("assemble")

allprojects {
	group = "com.allali84"
	version = "0.0.1-SNAPSHOT"
}

repositories {
	mavenCentral()
}

subprojects {

	repositories {
		mavenCentral()
	}
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "java")
	apply(plugin = "java-library")

	dependencyManagement {
		dependencies {
			imports {
				mavenBom("org.springframework.cloud:spring-cloud-dependencies:Greenwich.RELEASE")
			}
			dependencySet("io.swagger:1.5.12") {
				//entry("swagger-annotations") its inclu in swagger-jaxrs
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
		}
	}
}

apply plugin: 'war'

group = '[# th:text="${maven_groupid}"/]'
version = '1.0-SNAPSHOT'

sourceCompatibility = [# th:text="${se_version}"/]
targetCompatibility = [# th:text="${se_version}"/]

tasks.withType(JavaCompile) {
    options.encoding = 'UTF-8'
}

repositories {
    mavenCentral()
}

dependencies {
    providedCompile 'org.eclipse.microprofile:microprofile:[# th:text="${mp_depversion}"/]'
    [# th:if="${mainProject and mp_JWT_auth}"]
    implementation 'io.vertx:vertx-auth-jwt:3.9.2'
    [/]
    [# th:if="${mainProject and mp_graphql}"]
    providedCompile 'org.eclipse.microprofile.graphql:microprofile-graphql-api:1.0.2'
    [/]
}


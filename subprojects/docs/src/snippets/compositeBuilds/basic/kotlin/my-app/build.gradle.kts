plugins {
    java
    application
    idea
}

group = "org.sample"
version = "1.0"

application {
    mainClass.set("org.sample.myapp.Main")
}

dependencies {
    implementation("org.sample:number-utils:1.0")
    implementation("org.sample:string-utils:1.0")
}

repositories {
    jcenter()
}

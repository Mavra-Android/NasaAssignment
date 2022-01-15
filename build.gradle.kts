// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(ClassPlugins.build)
        classpath(ClassPlugins.kotlin)
        classpath(ClassPlugins.hilt)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20")
    }
}


allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}
import com.android.build.gradle.LibraryExtension

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

fun LibraryExtension.createDefaultConfig() = defaultConfig {
    minSdk = Configs.minSdk
    targetSdk = Configs.targetSdk
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    buildConfigField("String", "API_KEY", "\"8jDtuy7gV9RjdNSALskgrMCDO9K1efpepIy3g3j8\"")
    buildConfigField("String", "API_URL", "\"https://api.nasa.gov/mars-photos/api/\"")
}

fun LibraryExtension.createBuildTypes() = buildTypes {
    getByName("release") {
        isMinifyEnabled = false
        proguardFiles(
            getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
        )
    }
}

android {
    compileSdk = Configs.compileSdk
    createDefaultConfig()
    createBuildTypes()
    compileOptions {
        sourceCompatibility = Options.sourceCompatibility
        targetCompatibility = Options.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = Options.jvmTarget
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":shared"))
    implementation(Libs.coreKtx)
    implementation(Libs.retrofit)
    implementation(Libs.moshi)
    implementation(Libs.moshiConverter)
    implementation(Libs.hilt)
    kapt(Libs.hiltCompiler)
}
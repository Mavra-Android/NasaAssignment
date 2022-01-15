plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = Configs.compileSdk
    defaultConfig {
        minSdk = Configs.minSdk
        targetSdk = Configs.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Options.sourceCompatibility
        targetCompatibility = Options.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = Options.jvmTarget
    }
}

dependencies {
    implementation(Libs.coreKtx)
    implementation(Libs.retrofit)
    implementation(Libs.moshi)
    implementation(Libs.moshiConverter)
    implementation(Libs.hilt)
    implementation(Libs.coroutine)
    implementation("androidx.navigation:navigation-fragment-ktx:2.0.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
    kapt(Libs.hiltCompiler)
}
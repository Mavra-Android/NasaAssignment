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
    viewBinding{
        isEnabled = true
    }
}

dependencies {
    implementation(Libs.coreKtx)
    implementation(Libs.moshi)
    implementation(Libs.moshiConverter)
    implementation(Libs.hilt)
    implementation(Libs.coroutine)
    implementation(Libs.appCompat)
    implementation(Libs.material)
    kapt(Libs.hiltCompiler)
    implementation(Libs.recylerview)
    implementation(Libs.glide)
    annotationProcessor(Libs.glideProcess)
}
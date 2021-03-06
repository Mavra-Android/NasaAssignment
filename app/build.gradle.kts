plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
}


android {
    compileSdk = Configs.compileSdk
    defaultConfig {
        applicationId = Configs.applicationId
        versionCode = Configs.versionCode
        versionName = Configs.versionName
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
    viewBinding {
        isEnabled = true
    }


}

dependencies {
    implementation(Libs.coreKtx)
    implementation(Libs.hilt)
    implementation(Libs.appCompat)
    implementation(Libs.material)
    implementation(Libs.constaint)
    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUI)
    implementation(project(":features:vehicle_list"))
    implementation(project(":features:vehicle_detail"))
    implementation(project(":navgraph"))
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":core"))
    implementation(project(":shared"))
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.junit_ext)
    androidTestImplementation(Libs.espresso)
    kapt(Libs.hiltCompiler)


}

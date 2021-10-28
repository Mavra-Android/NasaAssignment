import org.gradle.api.JavaVersion

object Versions {
    const val kotlin = "1.5.31"
    const val coreKtx = "1.6.0"
    const val retrofit = "2.9.0"
    const val moshi = "1.12.0"
    const val hilt = "2.40"
    const val build = "7.0.3"
}

object Libs {
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val moshi by lazy { "com.squareup.moshi:moshi-kotlin:${Versions.moshi}" }
    val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltCompiler by lazy { "com.google.dagger:hilt-compiler:${Versions.hilt}" }
    val moshiConverter by lazy { "com.squareup.retrofit2:converter-moshi:${Versions.moshi}" }
}

object Configs {
    const val compileSdk = 31
    const val minSdk = 21
    const val targetSdk = 31
}

object ClassPlugins {
    val hilt by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
    val build by lazy { "com.android.tools.build:gradle:${Versions.build}" }
}


object Options {
    const val jvmTarget = "1.8"
    val sourceCompatibility = JavaVersion.VERSION_1_8
    val targetCompatibility = JavaVersion.VERSION_1_8
}

import org.gradle.api.JavaVersion

object Versions {
    const val kotlin = "1.5.31"
    const val coreKtx = "1.6.0"
    const val retrofit = "2.9.0"
    const val moshi = "1.12.0"
    const val hilt = "2.40"
    const val build = "7.0.3"
    const val appCompat = "1.3.1"
    const val material = "1.4.0"
    const val constraint = "2.1.1"
    const val navigation_fragment = "2.3.5"
    const val navigation_ui = "2.3.5"
    const val junit = "4.+"
    const val junit_ext = "1.1.3"
    const val espresso = "3.4.0"
}

object Libs {
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val moshi by lazy { "com.squareup.moshi:moshi-kotlin:${Versions.moshi}" }
    val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltCompiler by lazy { "com.google.dagger:hilt-compiler:${Versions.hilt}" }
    val moshiConverter by lazy { "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}"}
    val material by lazy { "com.google.android.material:material:${Versions.material}"}
    val constaint by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraint}"}
    val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigation_fragment}"}
    val navigationUI by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigation_ui}"}
    val junit by lazy { "junit:junit:${Versions.junit}"}
    val junit_ext by lazy { "androidx.test.ext:junit:${Versions.junit_ext}"}
    val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}"}
}

object Configs {
    const val compileSdk = 31
    const val minSdk = 21
    const val targetSdk = 31
    const val applicationId = "com.mavra.nasaassignment"
    const val versionCode = 1
    const val versionName = "1.0.0"
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

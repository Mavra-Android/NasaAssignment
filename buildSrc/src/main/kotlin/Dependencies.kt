import org.gradle.api.JavaVersion

object Versions {
    const val coreKtx = "1.6.0"
    const val retrofit = "2.9.0"
}

object Libs {
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
}


object Configs {
    const val compileSdk = 31
    const val minSdk = 21
    const val targetSdk = 31
}


object Options {
    const val jvmTarget = "1.8"
    val sourceCompatibility = JavaVersion.VERSION_1_8
    val targetCompatibility = JavaVersion.VERSION_1_8
}

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "io.chepherd.rc.auth"
    compileSdk = 34
    defaultConfig { minSdk = 26 }
    kotlinOptions { jvmTarget = "17" }
}

dependencies {
    implementation(libs.appauth)
    implementation(libs.security.crypto)
    implementation(libs.kotlinx.coroutines.android)
}

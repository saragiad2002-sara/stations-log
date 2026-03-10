
plugins {
  id("com.android.application") version "8.2.2"
  id("org.jetbrains.kotlin.android") version "1.9.22"
  id("kotlin-kapt")
}
android {
  namespace = "com.company.psreadings"
  compileSdk = 34
  defaultConfig {
    applicationId = "com.company.psreadings"
    minSdk = 26
    targetSdk = 34
    versionCode = 2
    versionName = "0.2"
  }
  buildFeatures { compose = true }
  composeOptions { kotlinCompilerExtensionVersion = "1.5.8" }
  packagingOptions { resources.excludes += "/META-INF/{AL2.0,LGPL2.1}" }
}
dependencies {
  val composeBom = platform("androidx.compose:compose-bom:2024.02.01")
  implementation(composeBom); androidTestImplementation(composeBom)
  implementation("androidx.core:core-ktx:1.12.0")
  implementation("androidx.activity:activity-compose:1.8.2")
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.material3:material3:1.2.1")
  implementation("androidx.compose.ui:ui-tooling-preview")
  debugImplementation("androidx.compose.ui:ui-tooling")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
  implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
  // Room
  implementation("androidx.room:room-runtime:2.6.1")
  kapt("androidx.room:room-compiler:2.6.1")
  implementation("androidx.room:room-ktx:2.6.1")
  // Notifications & Work
  implementation("androidx.work:work-runtime-ktx:2.9.0")
}

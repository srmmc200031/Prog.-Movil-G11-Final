plugins {


    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("androidx.navigation.safeargs.kotlin")

}


android {
    namespace = "com.poli.recetario_uno"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.poli.recetario_uno"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {

    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.foundation.layout.android)
    implementation(libs.androidx.ui.tooling.preview.android)
    implementation(libs.androidx.material3.android)
    implementation(libs.filament.android)

    // Fragment Container View

    val fragment_version="1.5.7"
    implementation("androidx.fragment:fragment-ktx:$fragment_version")

    implementation(libs.androidx.navigation.fragment)
    val navVersion = "2.7.0"


    //Navigation Component

    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")


    //CardView

    implementation(libs.androidx.cardview)

    //NavDraw dependencies

    implementation(libs.androidx.drawerlayout)
    implementation(libs.material.v190)
    implementation(libs.androidx.appcompat)


    //copiadas





    implementation("androidx.core:core-ktx:1.13.1")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)



}
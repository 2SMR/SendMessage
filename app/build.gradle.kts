plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.dokka)
    alias(libs.plugins.kotlin.parcelize)

}

android {
    namespace = "com.example.sendmessage_2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.sendmessage_2"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17) // Usa la versión JDK de tu proyecto (JVM_17, JVM_11, etc.)
        }
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.activity:activity-ktx:1.9.3")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // Libreria de github para crear actividad aboutus

}

// Configuración de rutas personalizadas para Dokka
tasks.dokkaHtml.configure {
    // Redirige el formato HTML a la raíz del proyecto
    outputDirectory.set(file("../documentation/html"))
}



tasks.dokkaJavadoc.configure {
    // Redirige el formato Javadoc a la raíz del proyecto
    outputDirectory.set(file("../documentation/javadoc"))
}
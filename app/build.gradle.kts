plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.umnapps"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.umnapps"
        minSdk = 30
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    // Multiple resource directories untuk organisasi drawable yang rapi
    sourceSets {
        getByName("main") {
            res.srcDirs(
                "src/main/res",
                "src/main/res-home",
                "src/main/res-banner",
                "src/main/res-berita",
                "src/main/res-fakultas",
                "src/main/res-fasilitas",
                "src/main/res-prodi",
                "src/main/res-pendaftaran",
                "src/main/res-sejarah",
                "src/main/res-icons"
            )
        }
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
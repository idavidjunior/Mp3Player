import java.text.SimpleDateFormat
import java.util.Date
import java.io.File
import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

fun loadVersionProps(): Properties {
    val props = Properties()
    val f = rootProject.file("version.properties")
    if (f.exists()) {
        f.inputStream().use { props.load(it) }
    }
    return props
}

fun getVersionCode(): Int {
    val p = loadVersionProps()
    val major = p.getProperty("VERSION_MAJOR", "1").toIntOrNull() ?: 1
    val minor = p.getProperty("VERSION_MINOR", "0").toIntOrNull() ?: 0
    val patch = p.getProperty("VERSION_PATCH", "0").toIntOrNull() ?: 0
    return major * 100000 + minor * 1000 + patch
}

fun getVersionName(): String {
    val p = loadVersionProps()
    return p.getProperty("VERSION_NAME", "1.1.0").ifBlank {
        val major = p.getProperty("VERSION_MAJOR", "1").toIntOrNull() ?: 1
        val minor = p.getProperty("VERSION_MINOR", "0").toIntOrNull() ?: 0
        val patch = p.getProperty("VERSION_PATCH", "0").toIntOrNull() ?: 0
        "$major.$minor.$patch"
    }
}

fun getBuildDate(): String {
    return SimpleDateFormat("yyyy-MM-dd").format(Date())
}

val releaseKeystore = file("../release.jks")
val hasReleaseKeystore = releaseKeystore.exists()

android {
    namespace = "com.mp3player"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mp3player"
        minSdk = 24
        targetSdk = 34
        versionCode = getVersionCode()
        versionName = getVersionName()
        buildConfigField("String", "BUILD_DATE", "\"${getBuildDate()}\"")

        externalNativeBuild {
            cmake {
                cppFlags += "-std=c++17"
                abiFilters += listOf("arm64-v8a", "armeabi-v7a")
            }
        }
        ndk {
            abiFilters += listOf("arm64-v8a", "armeabi-v7a")
        }
    }

    signingConfigs {
        getByName("debug") {
            storeFile = rootProject.file("debug.keystore")
            storePassword = "android"
            keyAlias = "androiddebugkey"
            keyPassword = "android"
        }
        create("release") {
            if (hasReleaseKeystore) {
                storeFile = releaseKeystore
                storePassword = "Mp3Player2024!"
                keyAlias = "release"
                keyPassword = "Mp3Player2024!"
            }
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
            signingConfig = signingConfigs.getByName("debug")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            if (hasReleaseKeystore) {
                signingConfig = signingConfigs.getByName("release")
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    ndkVersion = "28.2.13676358"

    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
}

val roomVersion = "2.6.1"
val glideVersion = "4.16.0"
val lifecycleVersion = "2.7.0"
val media3Version = "1.2.1"
val gsonVersion = "2.10.1"

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.media:media:1.7.0")
    implementation("androidx.fragment:fragment-ktx:1.6.2")

    // Room
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")

    // Glide
    implementation("com.github.bumptech.glide:glide:$glideVersion")

    // Lifecycle / ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // SwipeRefreshLayout
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    // Media3 / ExoPlayer
    implementation("androidx.media3:media3-exoplayer:$media3Version")
    implementation("androidx.media3:media3-session:$media3Version")
    implementation("androidx.media3:media3-ui:$media3Version")

    // JAudiotagger - primary tag processor (MP3, FLAC, OGG, WAV, AIFF, MP4)
    implementation("net.jthink:jaudiotagger:3.0.1")

    // mp3agic - fallback tag processor (lightweight, MP3-focused)
    implementation("com.mpatric:mp3agic:0.9.1")

    // Gson for JSON serialization
    implementation("com.google.code.gson:gson:$gsonVersion")
}
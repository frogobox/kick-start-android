import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    id("kotlin-parcelize")
}

ksp {
    arg("room.schemaLocation", "$projectDir/schemas") // If Using Ksp
}

base {
    // Naming APK // AAB
    archivesName = "${ProjectSetting.NAME_APK}-${android.defaultConfig.versionCode}"
}

android {

    namespace = "com.frogobox.kickstart"
    compileSdk = ProjectSetting.PROJECT_COMPILE_SDK

    defaultConfig {
        applicationId = ProjectSetting.PROJECT_APP_ID
        minSdk = ProjectSetting.PROJECT_MIN_SDK
        targetSdk = ProjectSetting.PROJECT_TARGET_SDK
        versionCode = ProjectSetting.PROJECT_VERSION_CODE
        versionName = ProjectSetting.PROJECT_VERSION_NAME

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Declaration build config
        buildConfigField("String", "DATABASE_NAME", ProjectSetting.DB)
        buildConfigField("String", "PREF_NAME", ProjectSetting.PREF)

        // Inject app name for debug
        resValue("string", "app_name", ProjectSetting.NAME_APP_DEBUG)

        // Inject admob id for debug
        resValue("string", "admob_app_id", ProjectAds.Admob.Debug.APP_ID)

        // Inject admob banner id for debug
        resValue("string", "admob_banner", ProjectAds.Admob.Debug.BANNER_ID)

        // Inject admob interstitial id for debug
        resValue("string", "admob_interstitial_id", ProjectAds.Admob.Debug.INTERSTITIAL_ID)

    }

    signingConfigs {
        create("release") {
            // You need to specify either an absolute path or include the
            // keystore file in the same directory as the build.gradle file.
            // [PROJECT FOLDER NAME/app/[COPY YOUT KEY STORE] .jks in here
            storeFile = file(ProjectSetting.PLAYSTORE_STORE_FILE)
            storePassword = ProjectSetting.PLAYSTORE_STORE_PASSWORD
            keyAlias = ProjectSetting.PLAYSTORE_KEY_ALIAS
            keyPassword = ProjectSetting.PLAYSTORE_KEY_PASSWORD
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            // Generated Signed APK / AAB
            signingConfig = signingConfigs.getByName("release")

            // Inject app name for release
            resValue("string", "app_name", ProjectSetting.NAME_APP)

            // Inject admob id for release
            resValue("string", "admob_app_id", ProjectAds.Admob.APP_ID)

            // Inject admob banner id for debug
            resValue("string", "admob_banner", ProjectAds.Admob.BANNER_ID)

            // Inject admob interstitial id for release
            resValue("string", "admob_interstitial_id", ProjectAds.Admob.INTERSTITIAL_ID)


        }
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }


}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
        freeCompilerArgs.add("-opt-in=kotlin.RequiresOptIn")
    }
}

dependencies {

    debugImplementation(libs.github.chucker)
    releaseImplementation(libs.github.chucker.no.op)

    implementation(libs.frogo.android) {
        exclude(
            group = "com.github.chuckerteam.chucker",
            module = "library"
        )
        exclude(
            group = "com.github.chuckerteam.chucker",
            module = "library-no-op"
        )
    }

    implementation(libs.hilt)

    ksp(libs.hilt.compiler)
    ksp(libs.androidx.lifecycle.compiler)
    ksp(libs.androidx.room.compiler)
    ksp(libs.github.glide.compiler)

}
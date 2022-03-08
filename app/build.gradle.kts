plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {

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

        // Naming APK // AAB
        setProperty("archivesBaseName", "${ProjectSetting.NAME_APK}(${versionName})")

        // Declaration apps name debug mode
        val debugAttribute = "Development"
        val nameAppDebug = "${ProjectSetting.NAME_APP} $debugAttribute"
        resourceConfigurations += setOf("en", "id")

        // Inject app name for debug
        resValue("string", "app_name", nameAppDebug)

        // Inject admob id for debug
        resValue("string", "admob_app_id", AdmobValue.debugAdmobAppId)
        resValue("string", "admob_banner", AdmobValue.debugAdmobBanner)
        resValue("string", "admob_interstitial", AdmobValue.debugAdmobInterstitial)
        resValue("string", "admob_interstitial_video", AdmobValue.debugAdmobInterstitialVideo)
        resValue("string", "admob_rewarded", AdmobValue.debugAdmobRewarded)
        resValue("string", "admob_rewarded_interstitial", AdmobValue.debugAdmobRewardedInterstitial)
        resValue("string", "admob_native_advanced", AdmobValue.debugAdmobNativeAdvanced)
        resValue("string", "admob_native_advanced_video", AdmobValue.debugAdmobNativeAdvancedVideo)

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
            resValue("string", "app_name", ProjectSetting.APP_NAME)


            // Inject admob id for release
            resValue("string", "admob_app_id", AdmobValue.releaseAdmobAppId)
            resValue("string", "admob_banner", AdmobValue.releaseAdmobBanner)
            resValue("string", "admob_interstitial", AdmobValue.releaseAdmobInterstitial)
            resValue("string", "admob_interstitial_video", AdmobValue.releaseAdmobInterstitialVideo)
            resValue("string", "admob_rewarded", AdmobValue.releaseAdmobRewarded)
            resValue("string", "admob_rewarded_interstitial", AdmobValue.releaseAdmobRewardedInterstitial)
            resValue("string", "admob_native_advanced", AdmobValue.releaseAdmobNativeAdvanced)
            resValue("string", "admob_native_advanced_video", AdmobValue.releaseAdmobNativeAdvancedVideo)

        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }

}


dependencies {

    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.preference:preference-ktx:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    implementation("androidx.work:work-runtime-ktx:2.7.1")
    implementation("androidx.activity:activity-ktx:${DependencyGradle.ACTIVITY_KTX_VERSION}")
    implementation("androidx.fragment:fragment-ktx:${DependencyGradle.FRAGMENT_KTX_VERSION}")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.0-alpha03")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")

    implementation("androidx.room:room-runtime:${DependencyGradle.ROOM_VERSION}")
    implementation("androidx.room:room-ktx:${DependencyGradle.ROOM_VERSION}")
    implementation("androidx.room:room-rxjava2:${DependencyGradle.ROOM_VERSION}")
    implementation("androidx.room:room-guava:${DependencyGradle.ROOM_VERSION}")

    implementation("com.google.code.gson:gson:2.9.0")
    implementation("com.google.android.material:material:1.5.0")
    implementation("com.google.android.gms:play-services-ads:20.6.0")

    implementation(Frogo.sdk)
    implementation(Frogo.ui)
    implementation(Frogo.consumeApi)
    implementation(Frogo.recyclerView)
    implementation(Frogo.admob)
    implementation(Frogo.log)
    implementation(Frogo.notification)

    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")

    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.21")

    implementation("com.facebook.stetho:stetho:1.5.1")
    implementation("com.readystatesoftware.chuck:library:1.1.0")

    implementation(Koin.core)
    implementation(Koin.android)
    implementation(Koin.androidCompat)
    implementation(Koin.androidxWorkManager)
    implementation(Koin.androidxCompose)

    implementation(Util.glide)
    kapt(Util.glideCompiler)

    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")

    kapt("androidx.lifecycle:lifecycle-compiler:2.5.0-alpha03")
    kapt("androidx.room:room-compiler:2.4.2")

    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.room:room-testing:${DependencyGradle.ROOM_VERSION}")
    testImplementation("io.insert-koin:koin-test:${DependencyGradle.KOIN_VERSION}")

    androidTestImplementation("androidx.room:room-testing:${DependencyGradle.ROOM_VERSION}")
    androidTestImplementation("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

}
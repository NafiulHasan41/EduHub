plugins {
    id("com.android.application")

    //Naf-firebase

    id("com.google.gms.google-services")
}


android {
    namespace = "com.nafsoft.aspireacademy"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.nafsoft.aspireacademy"
        minSdk = 24
        targetSdk = 33
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
}



dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.activity:activity:1.8.0")

    implementation("com.google.firebase:firebase-firestore:25.0.0")
    implementation("com.google.firebase:firebase-database:21.0.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    //Brinto
    implementation("com.google.firebase:firebase-storage:21.0.0")
//    implementation ("com.github.barteksc:android-pdf-viewer:3.2.0-beta.1")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")

    //Naf-firebase
    implementation(platform("com.google.firebase:firebase-bom:33.0.0"))
    //Naf-authentication
    implementation("com.google.firebase:firebase-auth")
    //Naf-lotte animation
    implementation ("com.airbnb.android:lottie:6.4.0")




}


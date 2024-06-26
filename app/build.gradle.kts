plugins {
    id("com.android.application")

    //Naf-firebase

    id("com.google.gms.google-services")
    //shawcha added
    id("org.jetbrains.kotlin.android") // Added this to ensure Kotlin plugin is applied
    id("androidx.navigation.safeargs")
    //end
}


android {
    namespace = "com.nafsoft.aspireacademy"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.nafsoft.aspireacademy"
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
}


val navVersion = "2.2.1"

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")



    //Naf-firebase
    implementation(platform("com.google.firebase:firebase-bom:33.0.0"))
    //Naf-authentication
    implementation("com.google.firebase:firebase-auth")



    /*
    * Naf-this is for firebase realtime database
    * */
    implementation("com.google.firebase:firebase-database")

    //Naf-lotte animation
    implementation ("com.airbnb.android:lottie:6.4.0")


    //Naf-unit testing
    testImplementation ("androidx.test:core:1.4.0")
    androidTestImplementation ("androidx.test:rules:1.5.0")
    androidTestImplementation ("androidx.test.espresso:espresso-intents:3.5.1")

    
    
      //Brinto
    implementation("com.google.firebase:firebase-storage:21.0.0")
    implementation ("com.github.barteksc:android-pdf-viewer:2.8.2")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    androidTestImplementation ("androidx.test:runner:1.3.0")
    testImplementation ("androidx.test:core:1.3.0")
    testImplementation ("org.mockito:mockito-core:3.6.28")
    testImplementation ("androidx.test.ext:junit:1.1.2")
    implementation("androidx.activity:activity:1.8.0")

    implementation("com.google.firebase:firebase-firestore:25.0.0")
    implementation("com.google.firebase:firebase-database:21.0.0")









    //Shawcha added glide , navigation,safeargs
    implementation("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")
    implementation("androidx.navigation:navigation-fragment:$navVersion")
    implementation("androidx.navigation:navigation-ui:$navVersion")
    implementation("com.google.firebase:firebase-firestore:25.0.0")



}



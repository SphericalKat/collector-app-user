object Modules {
    const val app = ":app"
    const val buildSrc = ":buildSrc"
    const val common = ":common"
    const val featureAuth = ":feature-auth"
    const val model = ":model"
    const val remote = ":remote"
    const val repository = ":repository"
}

object Config {
    const val compileSdkVersion = 29
    const val minSdkVersion = 19
    const val targetSdkVersion = 29
    const val versionCode = 1
    const val versionName = "1.0"
    const val applicationId = "com.dscvit.collectorappuser"
}

object Versions {

    const val kotlinVersion = "1.3.50"
    const val coroutinesVersion = "1.3.0-RC"

    const val ktxVersion = "1.1.0"
    const val appCompatVersion = "1.1.0"
    const val fragmentVersion = "1.2.0-alpha03"
    const val gradleVersion = "3.5.0"
    const val lifecycleVersion = "2.2.0-alpha04"
    const val navigationVersion = "2.1.0"
    const val roomVersion = "2.2.0-beta01"

    const val gsonVersion = "2.8.2"
    const val okhttp = "3.10.0"
    const val retrofit = "2.6.0"
    const val okHttp = "3.12.1"

    const val constraintLayoutVersion = "2.0.0-beta2"
    const val recyclerViewVersion = "1.1.0-beta04"
    const val materialVersion = "1.1.0-beta01"
    const val otpViewVersion = "2.0.3"
    const val materialDialogsCoreVersion = "3.1.1"
    const val spinkitVersion = "1.4.0"

    const val koinVersion = "2.0.1"
}

object Libs {

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"

    const val coreKtx = "androidx.core:core-ktx:${Versions.ktxVersion}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragmentVersion}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleVersion}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"

    //Networking
    const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhttp3LoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    //UI
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerViewVersion}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
    const val otpView = "com.github.mukeshsolanki:android-otpview-pinview:${Versions.otpViewVersion}"
    const val materialDialogs = "com.afollestad.material-dialogs:core:${Versions.materialDialogsCoreVersion}"
    const val spinKit = "com.github.ybq:Android-SpinKit:${Versions.spinkitVersion}"

    //Koin
    const val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koinVersion}"
}


# Android Training .....
Android training tasks projects


# libs
	implementation 'com.android.support:recyclerview-v7:28.0.0'
	implementation 'com.github.bumptech.glide:glide:4.8.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.8.0'
    implementation 'com.android.support:support-v4:28.0.0'
    implementation 'de.hdodenhof:circleimageview:2.2.0'
    implementation 'org.greenrobot:greendao:3.2.2'

    implementation 'com.google.code.gson:gson:2.8.5'
    implementation 'com.squareup.retrofit2:retrofit:2.5.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.5.0'

    implementation 'com.jakewharton:butterknife:9.0.0-rc2'
    annotationProcessor 'com.jakewharton:butterknife-compiler:9.0.0-rc2'

    implementation 'com.android.support:design:28.0.0'
    implementation 'com.android.support:support-v4:28.0.0'
	
	

apply plugin: 'com.jakewharton.butterknife'

compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
	
#build.gradle(Project: xxxx)
classpath 'org.greenrobot:greendao-gradle-plugin:3.2.2'
        classpath 'com.jakewharton:butterknife-gradle-plugin:9.0.0-r
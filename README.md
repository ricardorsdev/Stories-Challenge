# Stories-Challenge
===

This app requests API http://www.splashbase.co/api/v1/images/latest, which retrieves a list with the latest 10 files (photos and videos), stores received data on database SQLite (using Room), and show them in a similar way to typical Social Network's Stories. 
This is an Android Native app, developed with Kotlin.

## Settings
- minSdkVersion **23** (Android 6.0)
- targetSdkVersion **30**
- Android Studio 4.0+
- Gradle 4.1.3
- Kotlin 1.4.20

## Dependencies

- AndroidX
- Material
- Retrofit (for Integration with APIs)
- Gson (for JSON-to-Object conversion)
- Room (for managing CRUD on database)
- Dagger Hilt (for Dependency Injection)
- Navigation (for managing flow of screens)
- Stetho (for checking API requests) 
- Glide (for loading images on Views)

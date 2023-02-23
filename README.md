# Gradle and AGP 8.x no long includes dependencies' proguard rules

When using Gradle and AGP 8.x in release mode the app will crash due to the mavericks
consumer proguard rules not been included in the app.

If you open [gradle-wrapper.properties](./gradle/wrapper/gradle-wrapper.properties) and swap to gradle 7.6 and
open the root build file [build.gradle](./build.gradle) and swap to AGP 7.4.1.

Then the app works fine in release mode


## System
JDK: Android Studio JDK 17 bundled

Android Studio Flamingo | 2022.2.1 Beta 3

Build #AI-222.4459.24.2221.9601061, built on February 14, 2023

Runtime version: 17.0.6+0-17.0.6b802.4-9586694 aarch64

macOS 12.6.2


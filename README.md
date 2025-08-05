![Gemini_Generated_Image_c6ozd4c6ozd4c6oz](https://github.com/user-attachments/assets/c33efe57-1ead-46b1-8732-c1838d1f9820)

 [![platform](https://img.shields.io/badge/platform-android-brightgreen.svg)](https://developer.android.com/index.html)
 [![API](https://img.shields.io/badge/API-17%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=17)
 [![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](https://github.com/romellfudi/FudiSharePreference/blob/master/LICENSE)
 [![](https://github.com/romellfudi/FudiSharePreference/workflows/Android%20CI/badge.svg)](https://github.com/romellfudi/FudiSharePreference/actions)
 [![Bintray](https://img.shields.io/bintray/v/romllz489/maven/fudi-store.svg)](https://bintray.com/romllz489/maven/fudi-store)
 [![Bintray](https://img.shields.io/bintray/v/romllz489/maven/kotlin-fudi-store.svg)](https://bintray.com/romllz489/maven/kotlin-fudi-store)
 [![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-Fudi%20SharePreference-green.svg?style=flat )]( https://android-arsenal.com/details/1/7170 )
 [![Jitpack](https://jitpack.io/v/romellfudi/FudiSharePreference.svg)](https://jitpack.io/#romellfudi/FudiSharePreference)
[![](https://img.shields.io/badge/language-ES-blue.svg)](./README.es)

### by Romell Domínguez
[![](https://raw.githubusercontent.com/romellfudi/assets/master/favicon.ico)](https://www.romellfudi.com/)


## Downloads Dashboard
[![Data Studio](https://img.shields.io/badge/DATA%20STUDIO-DOWNLOADS%20REPORT-%23000000.svg?&style=for-the-badge&logo=data%3Aimage%2Fsvg%2Bxml%3Bbase64%2CPHN2ZyBpZD0iTGF5ZXJfMSIgZGF0YS1uYW1lPSJMYXllciAxIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAxMDcuNDcgMTAwIj48ZGVmcz48c3R5bGU%2BLmNscy0xe2ZpbGw6IzY2OWRmMzt9LmNscy0ye2ZpbGw6IzFhNzNlODt9PC9zdHlsZT48L2RlZnM%2BPHBhdGggY2xhc3M9ImNscy0xIiBkPSJNOTQuMDcsNzIuNzVINTVjLTkuNDYsMC0xNC43Myw2LjU5LTE0LjczLDEzLjYyQzQwLjIyLDkyLjc1LDQ0LjYyLDEwMCw1NSwxMDBoMzguOVY3Mi43NVoiLz48ZWxsaXBzZSBjbGFzcz0iY2xzLTIiIGN4PSI5NC4wNyIgY3k9Ijg2LjE1IiByeD0iMTMuNDEiIHJ5PSIxMy42MyIvPjxwYXRoIGNsYXNzPSJjbHMtMSIgZD0iTTUzLjYzLDM2LjI2SDE0LjczQzUuMjcsMzYuMjYsMCw0Mi44NiwwLDQ5Ljg5YzAsNi4zNyw0LjQsMTMuNjMsMTQuNzMsMTMuNjNoMzguOVoiLz48ZWxsaXBzZSBjbGFzcz0iY2xzLTIiIGN4PSI1My42MyIgY3k9IjQ5Ljg5IiByeD0iMTMuNDEiIHJ5PSIxMy42MyIvPjxwYXRoIGNsYXNzPSJjbHMtMSIgZD0iTTk0LjA3LDBINTVDNDUuNDksMCw0MC4yMiw2LjU5LDQwLjIyLDEzLjYzYzAsNi4zNyw0LjQsMTMuNjIsMTQuNzMsMTMuNjJoMzguOVYwWiIvPjxlbGxpcHNlIGNsYXNzPSJjbHMtMiIgY3g9Ijk0LjA3IiBjeT0iMTMuNjMiIHJ4PSIxMy40MSIgcnk9IjEzLjYzIi8%2BPC9zdmc%2B)](https://datastudio.google.com/reporting/ca7089b8-3d01-48ad-9750-62e5521da2c7)

Replace the following `latestVersion` annotation with java latest [![Bintray](https://img.shields.io/bintray/v/romllz489/maven/fudi-store.svg)](https://bintray.com/romllz489/maven/fudi-store) version, kotlin latest [![Bintray](https://img.shields.io/bintray/v/romllz489/maven/kotlin-fudi-store.svg)](https://bintray.com/romllz489/maven/kotlin-fudi-store) version

Add the following in your app's `build.gradle` file:

```groovy
repositories {
    jcenter()
}
dependencies {
    implementation 'com.romellfudi.store:fudi-store:{latestVersion}'
    implementation 'com.romellfudi.store:kotlin-fudi-store:{latestVersion}'
}
```

### How implement

Your class tag with JsonIgnoreProperties annotation and implements set & get.
Note: In kotlin language you must add the Annotation @Fudi on your data class, otherwise the extensions (`save`, `load` `clear`) would be ignored:

```java
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectBean {
    private String data;
    private ArrayList<ObjectDetailBean> objectDetailBeans;
    // need getters
    ...
}
```
```kotlin
@Fudi
@JsonIgnoreProperties(ignoreUnknown = true)
data class Class(var state: Boolean=false,
                            var value: Int=-1,
                            var valueDouble: Double=0.0,
                            var details: ArrayList<String>?=null)
```

In case attributes don't have setter method, the reference stores `null`value

Save different objects:

```java
SharePreferenced.save(myObjectClass,MyClass.class,"OBJ1");
 ```
```kotlin
// Using extensions & @Fudi 
val dataObject = Class(false,65,8.9,0,arrayListOf("hello", "wait", "bye"))
dataObject.save(tag="optional") // storage data
dataObject.load(tag="optional") // restore data or returns default object
dataObject.clear()
```

### License
```
Copyright 2016 Romell D.Z.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

**2016, November**

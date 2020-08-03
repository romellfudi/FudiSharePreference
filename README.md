[![](snapshot/background.png)](https://github.com/romellfudi/FudiSharePreference)

 [![platform](https://img.shields.io/badge/platform-android-brightgreen.svg)](https://developer.android.com/index.html)
 [![API](https://img.shields.io/badge/API-17%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=17)
 [![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](https://github.com/romellfudi/FudiSharePreference/blob/master/LICENSE)
 [![](https://github.com/romellfudi/FudiSharePreference/workflows/Android%20CI/badge.svg)](https://github.com/romellfudi/FudiSharePreference/actions)
 [![Bintray](https://img.shields.io/bintray/v/romllz489/maven/fudi-store.svg)](https://bintray.com/romllz489/maven/fudi-store)
 [![Bintray](https://img.shields.io/bintray/v/romllz489/maven/kotlin-fudi-store.svg)](https://bintray.com/romllz489/maven/kotlin-fudi-store)
 [![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-Fudi%20SharePreference-green.svg?style=flat )]( https://android-arsenal.com/details/1/7170 )
 [![Jitpack](https://jitpack.io/v/romellfudi/FudiSharePreference.svg)](https://jitpack.io/#romellfudi/FudiSharePreference)
 [![CircleCi](https://img.shields.io/circleci/project/github/romellfudi/FudiSharePreference.svg)](https://circleci.com/gh/romellfudi/FudiSharePreference/tree/master)
[![](https://img.shields.io/badge/language-ES-blue.svg)](./README.es)

### by Romell Domínguez
[![](https://raw.githubusercontent.com/romellfudi/assets/master/favicon.ico)](https://www.romellfudi.com/)

`latestVersion` is  [![Bintray](https://img.shields.io/bintray/v/romllz489/maven/fudi-store.svg)](https://bintray.com/romllz489/maven/fudi-store)

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

Your class tag with JsonIgnoreProperties annotation and implements set & get:

```java
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectBean {
    private String data;
    private ArrayList<ObjectDetailBean> objectDetailBeans;
    // need getters
    ...
}
```

In case attributes don't have setter method, the reference stores `null`value

Save a singleton object:

```java
SharePreferenced.save(myObjectClass,MyClass.class);
 ```

Save different objects:

```java
SharePreferenced.save(myObjectClass,MyClass.class,"OBJ1");
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
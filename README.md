## Android API from store Any kind of Data

 [![platform](https://img.shields.io/badge/platform-android-brightgreen.svg)](https://developer.android.com/index.html)
 [![API](https://img.shields.io/badge/API-17%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=17)
 [![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](https://github.com/romellfudi/FudiSharePreference/blob/master/LICENSE)
 [![Bintray](https://img.shields.io/bintray/v/romllz489/maven/fudi-store.svg)](https://bintray.com/romllz489/maven/fudi-store)

 [![Jitpack](https://jitpack.io/v/romellfudi/FudiSharePreference.svg)](https://jitpack.io/#romellfudi/FudiSharePreference)

### by Romell Domínguez

[![](snapshot/icono.png)](https://www.romellfudi.com/)

`latestVersion` es 1.0.a

Add the following in your app's `build.gradle` file:

```groovy
repositories {
    jcenter()
}
dependencies {
    implementation 'com.romellfudi.permission:fudi-store:1.0.a'
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

**2016, November**
## Android API para Almacenamiento de Data

 [![platform](https://img.shields.io/badge/platform-android-brightgreen.svg)](https://developer.android.com/index.html)
 [![API](https://img.shields.io/badge/API-17%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=17)
 [![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](https://github.com/romellfudi/FudiSharePreference/blob/master/LICENSE)
 [![Bintray](https://img.shields.io/bintray/v/romllz489/maven/fudi-store.svg)](https://bintray.com/romllz489/maven/fudi-store)
 [![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-Fudi%20SharePreference-green.svg?style=flat )]( https://android-arsenal.com/details/1/7170 )
 [![Jitpack](https://jitpack.io/v/romellfudi/FudiSharePreference.svg)](https://jitpack.io/#romellfudi/FudiSharePreference)

### by Romell Domínguez

[![](snapshot/icono.png)](https://www.romellfudi.com/)

`latestVersion` es 1.0.a

Agregar en tu archivo `build.gradle` del proyecto Android:

```groovy
repositories {
    jcenter()
}
dependencies {
    implementation 'com.romellfudi.permission:fudi-store:{latestVersion}'
}
```

### Implementación

Debes decorar tu clase con la anotación `@JsonIgnoreProperties` e implementar sus set & get:

```java
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectBean {
    private String data;
    private ArrayList<ObjectDetailBean> objectDetailBeans;
    // need getters
    ...
}
```

En caso los atributos no tengan métodos, se referenciará un valor ``nulo

Almacenando un objeto genérico de un clase:

```java
SharePreferenced.save(myObjectClass,MyClass.class);
 ```

Almacenando distintas instancias de una clase:

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
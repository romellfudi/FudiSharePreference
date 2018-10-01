## Android API from store Any kind of Data

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
```

In case attributes don't have setter method, the reference stores `null`value

Save a singleton object:

```java
 SharePreferenced.save(objectDetailBeanCurrent,MyClass.class);
 ```

Save different objects:

```java
 SharePreferenced.save(objectDetailBeanCurrent,MyClass.class,"OBJ1");
 ```

**2016, November**
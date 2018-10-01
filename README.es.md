## Android API para Almacenamiento de Data

### by Romell Domínguez

[![](snapshot/icono.png)](https://www.romellfudi.com/)

`latestVersion` es 1.0.a

Agregar en tu archivo `build.gradle` del proyecto Android:

```groovy
repositories {
    jcenter()
}
dependencies {
    implementation 'com.romellfudi.permission:fudi-store:1.0.a'
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
```

En caso los atributos no tengan métodos, se referenciará un valor ``nulo

Almacenando un objeto genérico de un clase:

```java
 SharePreferenced.save(objectDetailBeanCurrent,MyClass.class);
 ```

Almacenando distintas instancias de una clase:

```java
 SharePreferenced.save(objectDetailBeanCurrent,MyClass.class,"OBJ1");
 ```



**2016, November**
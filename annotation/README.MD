# Java注解  
**作用在代码的注解是：**  
- @Override-检查该方法是否是重载方法，如果发现其父类，或者是引用的接口中并没有该方法时，会报编译错误。
- @Deprecated-标记过时方法。如果使用该方法， 会报编译警告。
- @SuppressWarning-指示编译器去忽略注解中声明的警告  

作用在其它注解的注解（元注解）是：  
- @Retention-标识这个注解是怎么保存，是只在代码中，还是编译class文件中，或者是在运行时可以通过反射访问。
- @Document-标记这些注解是否包含在用户文档中。
- @Target-标记这个注解应该是哪种Java成员
- @Inherited-标记这个注解是继承于哪个注解类(默认注解并没有继承于任何子类)。  

从Java7开始，额外添加了3个注解  
- @SafeVarargs-Java7开始支持，忽略任何使用参数为泛型变量的方法或构造函数调用产生的警告。
- @FunctionalInterface-Java8开始支持，标识一个匿名函数或函数式接口。
- @Repeatable-Java8开始支持，标识其注解可以在同一个声明上使用多次。  

### 1.Annotation结构  
a) 1个Annotation和1个RetentionPolicy关联  
b) 1个Annotation和1~n个ElementType关联  
c) Annoation有许多实现类，包括：Deprecated、Documented、Inherited、Override等  

### 2.Annotation组成部分
Annotation.java  
```java
package java.lang.annotation;
public interface Annotation {
    boolean equals(Object obj);
    int hashCode();
    String toString();
    Class<? extends Annotation> annotationType();
}
```
ElementType.java
```java
package java.lang.annotation;
public enum ElementType {
    TYPE,/* 类、接口(包括注释类型)或枚举声明 */
    FIELD,/* 字段声明(包括枚举常量) */
    METHOD,/* 方法声明 */
    PARAMETER,/* 参数声明 */
    CONSTRUCTOR,/* 构造声明 */
    LOCAL_VARIABLE,/* 局部变量声明 */
    ANNOTATION_TYPE,/* 注解类型声明 */
    PACKAGE,/* 包声明 */
    TYPE_PARAMETER,/* 参数类型声明 */
    TYPE_USE/* 类型的使用 */
}
```
RetentionPolicy.java  
```java
package java.lang.annotation;
public enum RetentionPolicy {
    SOURCE,/* Annotation信息仅存在于编译器处理期间，编译器处理完之后就没有Annotaion信息了 */
    CLASS,/* 编译器将Annotation存储于类对应的.class文件中，但是不需要jvm实时读取，默认行为 */
    RUNTIME /* 编译器将Annotation存储于class文件中，并且可由jvm读入 */
}
```
### 3.Java自带的Annotation
a) 示例
```java
package com.heshi.annotation.demo1;
import java.lang.annotation.*;
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
}
```
@interface用来声明Annotation，@Documented用来表示该Annotation是否会出现在javadoc中，@Target用来指定Annotaion的类型，@Retention用来指定Annotaion的策略。  
java常用的Annotation：
@Deprecated -- @Deprecated所标注内容，不再被建议使用。  
@Override -- @Override只能标注方法，表示该方法覆盖父类中的方法。  
@Documented -- @Documented所标注内容，可以出现在javadoc中。  
@Inherited -- @Inherited只能被用来标注“Annotation类型”，它所标注的Annotation具有继承性。  
@Retention -- @Retention只能被用来标注“Annotation类型”，而且它被用来指定Annotation的RetentionPolicy属性。  
@Target -- @Target只能被用来标注“Annotation”类型，而且它被用来指定Annotation的ElementType属性。  
@SuppressWarnings -- @SuppressWarnings所标注内容产生的警告，编译器会对这些警告保持静默。  
**示例**  
@Inherited的使用示例如Base和Sub所示，Sub继承了Base，由于MyAnnotation是@Inherited，所以Sub也具有了注解MyAnnotation。  

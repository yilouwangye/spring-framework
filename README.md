#### IOC本质

**控制反转IoC（Inversion of Control），是一种设计思想，DI（依赖注入）是实现IoC的一种方法**。也有人认为DI只是IoC的另一种说法。没有IoC的程序中，我们使用面向对象编程，对象的创建与对象间的依赖关系完全硬编码在程序中，对象的创建由程序自己控制，控制反转后将对象的创建转移给第三方，个人认为所谓控制反转就是：获得依赖对象的方式反转了。

采用XML方式配置Bean的时候，Bean的定义信息是和实现分离的，而采用注解的方式可以把两者合为一体，Bean的定义信息直接以注解的形式定义在实现类中，从而达到了零配置的目的。
控制反转是一种通过描述（XML或注解）并通过第三方去生产或获取特定对象的方式。在Spring中实现控制反转的是IoC容器，其实现方法是依赖注入。

###### 实例

* mevn配置

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.0.RELEASE</version>
</dependency>
```

* 实体类

```java
public class User {
    private String name;

    public User(){
        System.out.println("User无参数构造");
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
```

* xml配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--等价于 Hello hello = new Hello() -->
    <bean id="hello" class="Hello">
        <!--设置变量值
        value:固定值；
        ref:动态值 -->
        <property name="string" value="Spring"/>
    </bean>
</beans>
```

* 测试类

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCode {
    public static void main(String[] args) {
        // org.springframework.context.ApplicationContext接口代表 Spring IoC 容器，并负责实例化，配置和组装 Bean,以下是实例化容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Object hello = context.getBean("hello");
        System.out.println(hello.toString());
    }
}
```

这个过程就叫控制反转：

**控制**：谁来控制对象的创建，传统应用程序的对象是由程序本身控制创建的，使用Spring后，对象是由Spring来创建的。

**反转**：程序本身不创建对象，而变成被动的接收对象。

**依赖注入**：就是利用set方法来进行注入的。

IOC是一种编程思想，由主动的编程变成被动的接收。**一句话搞定：对象由Spring来创建，管理，装配！**

#### IOC创建对象方式

在构造方法有参数的情况下：

1.通过下标赋值 

```xml
<bean id = "user" class="User">
	<constructor-arg index="0" value="200"/>
</bean>
```

2.通过类型赋值,不建议写，因为方法可能有多个相同类型的参数

```xml
<bean id = "user" class="User">
	<constructor-arg type="int" value="600"/>
</bean>
```

3.通过参数名赋值（推荐）

```xml
<bean id = "user" class="User">
	<constructor-arg name="num" value="500"/>
</bean>
```

#### Spring配置

###### 别名

```xml
<alias name="user" alias="userNew"/>
```

###### import导入

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
    <import resource="beans.xml"/>
    <import resource="beans1.xml"/>
    <import resource="beans2.xml"></import>
</beans>
```
#### 依赖注入

依赖注入（Dependency Injection）主要方式，基于**构造函数的依赖注入**和基于 **Setter 的依赖注入**。

#### setter注入

*复杂类型*

```java
public class Age {
    private Integer age;
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
```

*真实测试对象*

```java
public class Students {
    // alt + Insert -> get、set快捷键
    private String name;
    private Age age;
    private String[] likes;
    private List<String> skills;
    private Map<String,Integer> score;
    private Set<String> games;
    private Properties info;
    }
```

*beans.xml*

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="age" class="Age">
        <property name="age" value="20"/>
    </bean>
    <bean id="name" class="Students">
        <!-- 参数String类型-->
        <property name="name" value="jean"/>
        <!--复杂类型-->
        <property name="age" ref="age"/>
        <!--Array数组-->
        <property name="likes">
            <array>
                <value>football</value>
                <value>reading</value>
                <value>basketball</value>
            </array>
        </property>
        <!--List类型-->
        <property name="skills">
            <list>
                <value>coding</value>
                <value>sing</value>
                <value>writing</value>
            </list>
        </property>
        <!--Map类型-->
        <property name="score">
            <map>
                <entry key="语文" value="126"/>
                <entry key="物理" value="102"/>
            </map>
        </property>
        <!--set类型-->
        <property name="games">
            <set>
                <value>和平精英</value>
                <value>cross fire</value>
            </set>
        </property>
        <property name="info">
            <props>
                <prop key="localtion">2.006</prop>
                <prop key="url">www.baidu.com</prop>
            </props>
        </property>
    </bean>
</beans>
```

#### 扩展方式注入

###### P命名空间（p-namespace）& C命名空间（c-namespace）

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--p的含义为property-->
    <bean name="user" class="User" p:name="qoute" p:age="16"></bean>
    <!--需要有参数构造,创建无参数构造器是为了兼容p命名空间标签-->
    <bean name="user1" class="User" c:name="cat" c:age="8"></bean>
</beans>
```

导入junit，编写测试类

```java
@Test
public void testmodule(){
    ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
    User user = context.getBean("user",User.class);
    System.out.println(user);

    User user1 = context.getBean("user1",User.class);
    System.out.println(user1);
}
```
#### Bean总览

Spring IoC 容器 Management 一个或多个 bean。这些 bean 是使用您提供给容器的配置元数据创建的(例如，以 XML `<bean/>`定义的形式)

创建 bean 定义时，将创建一个配方来创建该 bean 定义所定义的类的实际实例，Spring 框架支持六个范围

<div><img src="https://gitee.com/tianyilouwangye/up/raw/master/image/20210302165929.png"></div>

###### 单例模式

定义一个 bean 定义并且其作用域为单例时，Spring IoC 容器将为该 bean 定义所定义的对象创建一个实例。

该单个实例存储在此类单例 bean 的高速缓存中，并且对该命名 bean 的所有后续请求和引用都返回该高速缓存的对象

<div><img src="https://gitee.com/tianyilouwangye/up/raw/master/image/20210303100405.png"></div>

定义方式：

```xml
<bean id="accountService" class="com.something.DefaultAccountService" scope="singleton"/>
```

###### 原型模式

每次对特定 bean 提出请求时，bean 部署的非单一原型范围都会导致创建一个新 bean 实例。

也就是说，将 Bean 注入到另一个 Bean 中，或者您可以通过容器上的`getBean()`方法调用来请求它。通常，应将原型作用域用于所有有状态 Bean

<div><img src="https://gitee.com/tianyilouwangye/up/raw/master/image/20210303100632.png"></div>

定义方式：

```xml
<bean id="accountService" class="com.something.DefaultAccountService" scope="prototype"/>
```

其余的request、session、application、这些只能在web开发中使用到！

#### 自动装配

自动装配是Spring满足bean依赖的一种方式，Spring会在上下文中自动寻找，并自动为bean装配属性

Spring三种装配方式：

* 在xml显示配置
* 在java显示配置
* 隐式的自动装配bean

Car类

```java
public class Car {
    public void bland(){
        System.out.println("Ferrari");
    }
}
```

MiniCar类

```java
public class MiniCar {
    public void bland(){
        System.out.println("Polo");
    }
}
```

People类

```java
public class People {
    private Car car;
    private MiniCar miniCar;
    public String name;
}
```

beans.xml配置

```xml
<bean id="car" class="Car"/>
<bean id="minicar" class="MiniCar"/>
<bean id="people" class="People">
    <property name="name" value="cat"/>
    <property name="car" ref="car"/>
    <property name="miniCar" ref="minicar"/>
</bean>
```

###### ByName自动装配

ByName的时候，需要保证所有bean的id唯一，并且这个bean需要和自动注入的属性的set方法的值

```xml
<bean id="car" class="Car"/>
<bean id="miniCar" class="MiniCar"/>
<!--会在容器上下文寻找，和自己对象set方法名后面的值对应的bean id 
即：setCar(Car car)，查找id="car"，首字母忽略大小写，如上面的<bean id="minicar" class="MiniCar"/>会报错
-->
<bean id="people" class="People" autowire="byName">
<property name="name" value="cat"/>
</bean>
```

###### ByType自动装配

ByType的时候，需要保证所有bean的class唯一，并且这个bean需要和自动注入的属性的类型一致！

```xml
<bean id="car" class="Car"/>
<bean id="miniCar" class="MiniCar"/>
<!--byType会在容器上下文寻找，和自己对象类型相同的bean
此时跟id的赋值无关
-->
<bean id="people" class="People" autowire="byType">
    <property name="name" value="cat"/>
</bean>
```

###### 注解配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>
    <bean id="people" class="People"/>
    <!--id的值可以任意-->
    <bean id="car" class="Car"/>
    <bean id="minicar" class="MiniCar"/>
    <bean id="a22222" class="BusinessCar"/>
</beans>
```

@Autowired一般写在属性上，也可以在setter上声明；

声明了注解，可以不用写set方法了；

@Autowired首先根据ByType方式进行装配，当相同类对应多个时，根据ByName进行装配。

```java
public class People {
    /**
     * 注解方式可以省略setter
     * @Autowired(required = false)  属性为空，也不会报错
     * Qualifier指定 bean id名称
     * @Resource也可以指定name, @Resource(name="car")
     */
    @Autowired
    private Car car;

    @Resource
    private MiniCar miniCar;

    @Autowired
    @Qualifier(value = "a22222")
    private BusinessCar businessCar;

    public String name;

    public BusinessCar getBusinessCar() {
        return businessCar;
    }

    public Car getCar() {
        return car;
    }

    public MiniCar getMiniCar() {
        return miniCar;
    }

    public String getName() {
        return name;
    }
}
```

###### @Resource和@Autowired的区别

@Autowired通过byType的方式实现，而且必须要求这个对象存在；

@Resource默认通过byName的方式实现，如果找不到名字，则通过byType实现！如果两个都找不到的情况下，就报错；
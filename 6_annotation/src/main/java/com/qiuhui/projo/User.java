package com.qiuhui.projo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Compoment(组件) --> 等效于 <bean id="user" class="com.qiuhui.projo.User"/>
 * @Value() --> 等效于 <property name="age" value="8"/>
 */

@Component
@Scope("singleton")
public class User {
    public String name = "jean";
    @Value("6")
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
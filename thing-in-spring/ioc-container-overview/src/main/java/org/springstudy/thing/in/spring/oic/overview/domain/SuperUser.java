package org.springstudy.thing.in.spring.oic.overview.domain;

import org.springstudy.thing.in.spring.oic.overview.annotation.Super;

/**
 * @author chihay
 * @Description
 */
@Super
public class SuperUser extends User {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "age='" + age + '\'' +
                "} " + super.toString();
    }
}

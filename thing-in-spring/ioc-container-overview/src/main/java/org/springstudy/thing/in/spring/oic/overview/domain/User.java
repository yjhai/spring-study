package org.springstudy.thing.in.spring.oic.overview.domain;

/**
 * @author chihay
 * @Description
 */
public class User {

    Long id;

    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static User createUser(){
        User user = new User();
        user.setId(12L);
        user.setName("create User by static method");
        return user;
    }
}

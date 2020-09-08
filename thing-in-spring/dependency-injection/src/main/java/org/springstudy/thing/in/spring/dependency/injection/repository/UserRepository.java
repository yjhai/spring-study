package org.springstudy.thing.in.spring.dependency.injection.repository;

import org.springstudy.thing.in.spring.oic.overview.domain.User;

/**
 * @author chihay
 * @Description
 */
public class UserRepository {

    private User user;

    public User getUser() {
        return user;
    }

    public UserRepository() {
    }

    public UserRepository(User user) {
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "user=" + user +
                '}';
    }
}

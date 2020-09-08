package org.springstudy.thing.in.spring.spring.bean.factory;

import org.springstudy.thing.in.spring.oic.overview.domain.User;

/**
 * @author chihay
 * @Description
 */
public interface UserFactory {

    default User createUser(){
        return User.createUser();
    }
}

package org.springstudy.thing.in.spring.spring.bean.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springstudy.thing.in.spring.oic.overview.domain.User;

/**
 * @author chihay
 * @Description
 */
public class UserFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}

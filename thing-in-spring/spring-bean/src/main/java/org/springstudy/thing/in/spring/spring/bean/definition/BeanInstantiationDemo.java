package org.springstudy.thing.in.spring.spring.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springstudy.thing.in.spring.oic.overview.domain.User;

/**
 * @author chihay
 * @Description
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/bean-instantiation-context.xml");

        User userByStaticMethod = beanFactory.getBean("user-by-static-method", User.class);
        User userByFactory = beanFactory.getBean("user-by-static-factory", User.class);
        User userByFactoryBean = beanFactory.getBean("user-by-factory-bean", User.class);
        System.out.println(userByStaticMethod);
        System.out.println(userByFactory);
        System.out.println(userByFactoryBean);
        System.out.println(userByFactory == userByStaticMethod);
        System.out.println(userByFactory == userByFactoryBean);
        System.out.println(userByFactoryBean == userByStaticMethod);

    }
}

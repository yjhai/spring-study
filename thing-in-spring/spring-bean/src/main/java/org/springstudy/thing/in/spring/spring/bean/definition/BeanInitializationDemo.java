package org.springstudy.thing.in.spring.spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springstudy.thing.in.spring.spring.bean.factory.DefaultUserFactory;
import org.springstudy.thing.in.spring.spring.bean.factory.UserFactory;

/**
 * @author chihay
 * @Description
 */
public class BeanInitializationDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDemo.class);

        applicationContext.refresh();
        System.out.println("spring ApplicationContext started......");

        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        System.out.println(userFactory);
        System.out.println("spring ApplicationContext 准备 closed......");//说明是close 来销毁的

        applicationContext.close();
        System.out.println("spring ApplicationContext closed......");
    }

    @Bean(initMethod = "initUserFactory",destroyMethod = "doDestory")
    //@Lazy
    public UserFactory defaultUserFactory(){
        return new DefaultUserFactory();
    }
}

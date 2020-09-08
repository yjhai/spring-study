package org.springstudy.thing.in.spring.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springstudy.thing.in.spring.oic.overview.domain.User;

/**
 * @author chihay
 * @Description
 */
public class ObjectProviderDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);

        applicationContext.refresh();

        lookupByObjectProvider(applicationContext);
        lookupIfAvaiable(applicationContext);

        applicationContext.close();
    }

    private static void lookupIfAvaiable(AnnotationConfigApplicationContext applicationContext) {

        ObjectProvider<User> beanProvider = applicationContext.getBeanProvider(User.class);
        User user = beanProvider.getIfAvailable(User::createUser);
        System.out.println("当前user 对象"+user);

    }

    @Bean
    public String helloWorld(){
        return "hello World";
    }

    public static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext){

        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(beanProvider.getObject("helloWorld"));

    }
}

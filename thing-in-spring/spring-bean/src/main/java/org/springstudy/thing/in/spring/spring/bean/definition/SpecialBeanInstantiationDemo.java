package org.springstudy.thing.in.spring.spring.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springstudy.thing.in.spring.spring.bean.factory.UserFactory;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author chihay
 * @Description
 */
public class SpecialBeanInstantiationDemo {

    public static void main(String[] args) throws Exception {

        //整合容器
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/special-bean-instantiation-context.xml");
        ServiceLoader userServiceLoader = beanFactory.getBean("userServiceLoader", ServiceLoader.class);
        displayServiceLoader(userServiceLoader);



        //demoServerLoader();
    }

    //普通serviceLoader 方式。文件名是接口全类名，内容是接口实现全类名
    public static void demoServerLoader(){
        //会返回多个
        ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(serviceLoader);
    }

    //方式二 整合容器(只会返回一个，也有返回多个的实现)
    private static void displayServiceLoader(ServiceLoader serviceLoader){

        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()){
            UserFactory userFactory = iterator.next();
            System.out.println(userFactory.createUser());
        }
    }
}

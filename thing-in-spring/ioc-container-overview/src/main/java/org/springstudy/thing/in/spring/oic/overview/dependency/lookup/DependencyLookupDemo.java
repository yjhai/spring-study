package org.springstudy.thing.in.spring.oic.overview.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springstudy.thing.in.spring.oic.overview.annotation.Super;
import org.springstudy.thing.in.spring.oic.overview.domain.User;

import java.util.Map;

/**
 * 依赖查找示例
 * 1. 通过名称的方式来查找
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");

        //根据名称实时查找
        lookupInRealTime(beanFactory);
        lookupInLazy(beanFactory);

        lookupByType(beanFactory);

        lookupByCollectionType(beanFactory);

        lookupByAnnotation(beanFactory);
    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {

        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找所有@Super对象:"+users);
        }


    }

    private static void lookupByCollectionType(BeanFactory beanFactory) {

        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找所有对象:"+users);
        }



    }

    private static void lookupByType(BeanFactory beanFactory) {

        User user = beanFactory.getBean(User.class);
        System.out.println("类型查找:"+user);
    }

    private static void lookupInRealTime(BeanFactory beanFactory){
        //根据名称实时查找
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找:"+user);

    }

    private static void lookupInLazy(BeanFactory beanFactory){

        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User object = objectFactory.getObject();
        System.out.println("延迟查找:"+object);

    }
}

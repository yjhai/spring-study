package org.springstudy.thing.in.spring.oic.overview.dependency.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springstudy.thing.in.spring.oic.overview.domain.User;

import java.util.Map;

/**
 * @author chihay
 * @Description ApplicationContext容器使用
 */
public class ApplicationContextAsIocContainer {

    public static void main(String[] args) {

        // 创建 BeanFactory
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前类作为配置类
        applicationContext.register(ApplicationContextAsIocContainer.class);

        applicationContext.refresh();

        lookupByCollectionType(applicationContext);
    }

    @Bean
    private User user(){
        User user = new User();
        user.setId(2L);
        user.setName("chihay1");
        return user;
    }

    private static void lookupByCollectionType(BeanFactory beanFactory) {

        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找所有对象:"+users);
        }

    }
}

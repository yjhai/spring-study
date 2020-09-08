package org.springstudy.thing.in.spring.oic.overview.dependency.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springstudy.thing.in.spring.oic.overview.annotation.Super;
import org.springstudy.thing.in.spring.oic.overview.domain.User;
import org.springstudy.thing.in.spring.oic.overview.repository.UserRepository;

import java.util.Map;

/**
 * 依赖注入和依赖来源示例
 *
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        //1、自定义
        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");
        System.out.println(userRepository.getUsers());

        //2、依赖注入(内建依赖)
        System.out.println(userRepository.getBeanFactory());
        System.out.println(userRepository.getBeanFactory() == beanFactory);

        //3、容器内建bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println(environment);

        //抛异常 No qualifying bean of type 'org.springframework.beans.factory.BeanFactory' available
        //System.out.println(beanFactory.getBean(BeanFactory.class));

        ObjectFactory<User> userObjectFactory = userRepository.getUserObjectFactory();
        System.out.println(userObjectFactory.getObject());

        ObjectFactory<ApplicationContext> objectFactory = userRepository.getObjectFactory();
        System.out.println(objectFactory.getObject());

        System.out.println(objectFactory.getObject() == beanFactory);
    }


}

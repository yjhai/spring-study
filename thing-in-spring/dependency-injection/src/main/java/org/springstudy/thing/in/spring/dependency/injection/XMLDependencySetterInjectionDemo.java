package org.springstudy.thing.in.spring.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springstudy.thing.in.spring.dependency.injection.repository.UserRepository;

/**
 * @author chihay
 * @Description
 */
public class XMLDependencySetterInjectionDemo {

    public static void main(String[] args) {

        //获取容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //加载xml
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:/META-INF/dependency-setter-injection.xml");

        //查找
        UserRepository userRepository = beanFactory.getBean(UserRepository.class);
        System.out.println(userRepository.getUser());

    }
}

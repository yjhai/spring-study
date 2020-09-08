package org.springstudy.thing.in.spring.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springstudy.thing.in.spring.dependency.injection.repository.UserRepository;
import org.springstudy.thing.in.spring.oic.overview.domain.User;

/**
 * @author chihay
 * @Description
 */
public class AnnotationDependencySetterInjectionDemo {

    public static void main(String[] args) {

        //获取容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //注册配置类，告诉容器在哪个地方扫描
        applicationContext.register(AnnotationDependencySetterInjectionDemo.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        reader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup-context.xml");

        applicationContext.refresh();


        //查找
        UserRepository userRepository = applicationContext.getBean(UserRepository.class);
        System.out.println(userRepository.getUser());

        applicationContext.close();

    }

    @Bean
    public UserRepository userRepository(User user){
        UserRepository userRepository = new UserRepository();
        userRepository.setUser(user);
        return userRepository;
    }
}

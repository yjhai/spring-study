package org.springstudy.thing.in.spring.dependency.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springstudy.thing.in.spring.dependency.injection.repository.UserRepository;

/**
 * @author chihay
 * @Description
 */
public class APIDependencyConstructInjectionDemo {

    public static void main(String[] args) {

        //获取容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //注册配置类
        applicationContext.register(APIDependencyConstructInjectionDemo.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        reader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup-context.xml");

        //创建 UserRepository BeanDefinition
        BeanDefinition beanDefinition = createBeanDefinition();
        applicationContext.registerBeanDefinition("userRepository",beanDefinition);

        applicationContext.refresh();

        //查找
        UserRepository userRepository = applicationContext.getBean(UserRepository.class);
        System.out.println(userRepository.getUser());

        applicationContext.close();
    }

    public static BeanDefinition createBeanDefinition(){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserRepository.class);
        beanDefinitionBuilder.addConstructorArgReference("superUser");
        return beanDefinitionBuilder.getBeanDefinition();
    }
}

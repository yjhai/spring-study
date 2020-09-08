package org.springstudy.thing.in.spring.oic.overview.dependency.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springstudy.thing.in.spring.oic.overview.domain.User;

import java.util.Map;

/**
 * @author chihay
 * @Description BeanFactory容器使用(没有高级功能)
 */
public class BeanFactoryAsIocContainer {

    public static void main(String[] args) {

        // 配置 XML 配置文件
        // 创建 BeanFactory
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        //加载配置
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        String location = "classpath:/META-INF/dependency-lookup-context.xml";

        int number = reader.loadBeanDefinitions(location);

        System.out.println(number);

        lookupByCollectionType(defaultListableBeanFactory);
    }

    private static void lookupByCollectionType(BeanFactory beanFactory) {

        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找所有对象:"+users);
        }

    }
}

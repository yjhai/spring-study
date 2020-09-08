package org.springstudy.thing.in.spring.spring.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springstudy.thing.in.spring.oic.overview.domain.User;

/**
 * @author chihay
 * @Description
 */
public class BeanAliasDemo {

    public static void main(String[] args) {

        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/bean-definitions-context.xml");

        User chihayUser = beanFactory.getBean("chihayUser",User.class);
        User user = beanFactory.getBean("user",User.class);
        System.out.println(chihayUser == user);

    }
}

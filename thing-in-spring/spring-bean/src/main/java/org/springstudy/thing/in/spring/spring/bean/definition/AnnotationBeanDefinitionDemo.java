package org.springstudy.thing.in.spring.spring.bean.definition;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springstudy.thing.in.spring.oic.overview.domain.User;

/**
 * @author chihay
 * @Description BeanDefinition 注入 注解形式
 *
 * 2、Java注解
 *  @Bean
 *  @Component
 *  @Import
 */
@Import(AnnotationBeanDefinitionDemo.config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {

        //获取容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //注册配置类，告诉容器在哪个地方扫描
        applicationContext.register(AnnotationBeanDefinitionDemo.class);

        //不会重复创建
        registerUsrBeanDefinition(applicationContext,"user");
        registerUsrBeanDefinition(applicationContext);

        applicationContext.refresh();

        System.out.println("获取user beans:"+applicationContext.getBeansOfType(User.class));
        System.out.println("获取config beans:"+applicationContext.getBeansOfType(config.class));

    }

    private static void registerUsrBeanDefinition(AnnotationConfigApplicationContext applicationContext) {
        registerUsrBeanDefinition(applicationContext,null);
    }

    private static void registerUsrBeanDefinition(AnnotationConfigApplicationContext applicationContext, String name) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("id",24L)
                .addPropertyValue("name","chihay");

        if (StringUtils.hasText(name)){
            applicationContext.registerBeanDefinition(name,beanDefinitionBuilder.getBeanDefinition());
        }else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),applicationContext);
        }

    }

    //2、@component方式
    //@Component
    public static class config{

        //1、@Bean方式
        @Bean
        public User user(){
            User user = new User();
            user.setId(23L);
            user.setName("chihay 23");
            return user;
        }

    }

}

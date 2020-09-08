package org.springstudy.thing.in.spring.spring.bean.definition;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springstudy.thing.in.spring.oic.overview.domain.User;

/**
 * @author chihay
 * @Description
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {

        // 1.通过 BeanDefinitionBuilder 构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("id",23)
                .addPropertyValue("name","chihay");

        //不是最终状态，还是可以修改，比如dependency
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        //2. 通过 AbstractBeanDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues
                .add("id",24)
                .add("name","chihay");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);
    }
}

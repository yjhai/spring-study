package org.springstudy.thing.in.spring.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.TreeMap;

/**
 * @author chihay
 * @Description
 */
public class HierarchicalDependencyLookupDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(HierarchicalDependencyLookupDemo.class);

        applicationContext.refresh();


        //HierarchicalBeanFactory <- ConfigurableBeanFactory <- ConfigurableListableBeanFactory
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        System.out.println(beanFactory.getParentBeanFactory());

        //设置ParentBeanFactory
        ConfigurableListableBeanFactory parentBeanFactory = createParentBeanFactory();
        beanFactory.setParentBeanFactory(parentBeanFactory);
        System.out.println(beanFactory.getParentBeanFactory());

        //displayContainsLocalBean(beanFactory,"user");
        //displayContainsLocalBean(parentBeanFactory,"user");
        displayContainsBean(beanFactory,"user");

        applicationContext.close();
    }

    public static void displayContainsBean(HierarchicalBeanFactory beanFactory,String beanName){

        System.out.printf("当前BeanFactory[%s] 是否包含Bean[%s] : %s\n",beanFactory,beanName,containsBean(beanFactory,beanName));
    }

    public static boolean containsBean(HierarchicalBeanFactory beanFactory,String beanName){

        BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();
        if (parentBeanFactory instanceof HierarchicalBeanFactory){
            HierarchicalBeanFactory hierarchicalBeanFactory = HierarchicalBeanFactory.class.cast(parentBeanFactory);
            if (containsBean(hierarchicalBeanFactory,beanName)){
                return true;
            }
        }
        return beanFactory.containsBean(beanName);
    }

    public static void displayContainsLocalBean(HierarchicalBeanFactory beanFactory,String beanName){
        System.out.printf("当前BeanFactory[%s] 是否包含Bean[%s] : %s\n",beanFactory,beanName,beanFactory.containsLocalBean(beanName));
    }

    public static ConfigurableListableBeanFactory createParentBeanFactory(){

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        reader.loadBeanDefinitions(location);
        return beanFactory;
    }
}

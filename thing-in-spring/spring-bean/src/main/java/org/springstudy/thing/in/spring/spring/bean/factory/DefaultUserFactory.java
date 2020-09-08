package org.springstudy.thing.in.spring.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author chihay
 * @Description
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {

    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct 方式初始化......");
    }

    public void initUserFactory(){
        System.out.println("自定义方法 方式初始化......");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean.afterPropertiesSet 方式初始化......");
    }

    @PreDestroy
    public void destroyUserFactory(){
        System.out.println("@PreDestroy 方式销毁......");
    }

    public void doDestory(){
        System.out.println("自定义方法 方式销毁......");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean.destroy 方式销毁......");
    }
}

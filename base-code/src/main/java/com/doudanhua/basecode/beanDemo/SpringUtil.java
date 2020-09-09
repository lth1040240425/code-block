package com.doudanhua.basecode.beanDemo;

import javafx.application.Application;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author zhangqian
 * @Description TODO
 * @Date 2020/9/9 16:20
 */
@Component
public class SpringUtil  implements ApplicationContextAware {
    private static ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringUtil.applicationContext!=null){
            SpringUtil.applicationContext=applicationContext;
        }
    }
    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T>tClass){
        return applicationContext.getBean(tClass);
    }

    public static <T>T getBean(String name,Class<T>tClass){
        return applicationContext.getBean(name,tClass);
    }
}

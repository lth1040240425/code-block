package com.doudanhua.basecode.beanDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @Author zhangqian
 * @Description TODO
 * @Date 2020/9/9 16:08
 */
@Service
public class beanFactory {
    @Autowired
    private ApplicationContext context;

    public <T> T getBean(Class<T> tClass) {
        return context.getBean(tClass);
    }

    public Object getBean(String tclassName){
        return context.getBean(tclassName);
    }

}

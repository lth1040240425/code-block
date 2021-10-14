package com.doudanhua.basecode.jackjson;

import org.reflections.Reflections;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author zhangqian
 * @Description TODO
 * @Date 2021/10/14 15:54
 */
@Service
public class ClassCacheInitializing implements InitializingBean {

    private String packages="com.doudanhua.basecode";

    /**
     * 反射会有点耗时，所以程序启动的时候加载完放到缓存里面去,后面要用的时候直接去缓存取
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        Reflections reflections = new Reflections(packages);
        if (reflections != null) {
            ReflectionsCache.setReflections(reflections);
        }
    }
}

package com.doudanhua.basecode.jackjson;

import org.reflections.Reflections;

/**
 * @Author zhangqian
 * @Description TODO
 * @Date 2021/10/14 15:54
 */
public class ReflectionsCache {
    private static Reflections reflections;

    public static void setReflections(Reflections _reflections) {
        reflections = _reflections;
    }

    public static Reflections getReflections() {
        return reflections;
    }
}

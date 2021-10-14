package com.doudanhua.basecode.jackjson;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import net.logstash.logback.encoder.org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;

import java.util.Set;

/**
 * @Author zhangqian
 * @Description TODO
 * @Date 2021/10/14 15:53
 */
public class JacksonTypeIdResolver implements TypeIdResolver {
    private JavaType baseType;

    @Override
    public void init(JavaType javaType) {
        baseType = javaType;
    }


    @Override
    public String idFromValue(Object o) {
        return idFromValueAndType(o, o.getClass());
    }


    @Override
    public String idFromValueAndType(Object o, Class<?> aClass) {
        //有出现同名类是可以用这个来做区别
        JsonTypeName annotation = aClass.getAnnotation(JsonTypeName.class);
        if (annotation != null) {
            return annotation.value();
        }
        String name = aClass.getName();
        String[] splits = StringUtils.split(name, ".");
        String className = splits[splits.length - 1];
        return className;
    }


    @Override
    public JavaType typeFromId(DatabindContext databindContext, String type) {
        Class<?> clazz = getSubType(type);
        if (clazz == null) {
            throw new IllegalStateException("cannot find class '" + type + "'");
        }
        return databindContext.constructSpecializedType(baseType, clazz);
    }

    public Class<?> getSubType(String type) {
        Reflections reflections = ReflectionsCache.getReflections();
        Set<Class<?>> subTypes = reflections.getSubTypesOf((Class<Object>) baseType.getRawClass());
        for (Class<?> subType : subTypes) {
            JsonTypeName annotation = subType.getAnnotation(JsonTypeName.class);
            if (annotation != null && annotation.value().equals(type)) {
                return subType;
            } else if (subType.getSimpleName().equals(type)) {
                return subType;
            }
            else if(subType.getName().equals(type)){
                return subType;
            }
        }
        return null;
    }

    @Override
    public String idFromBaseType() {
        return idFromValueAndType(null, baseType.getClass());
    }

    @Override
    public String getDescForKnownTypeIds() {
        return null;
    }

    @Override
    public JsonTypeInfo.Id getMechanism() {
        return JsonTypeInfo.Id.CUSTOM;
    }

}

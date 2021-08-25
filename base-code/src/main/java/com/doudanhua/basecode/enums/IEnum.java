package com.doudanhua.basecode.enums;

import java.util.EnumSet;
import java.util.Objects;

/**
 * @Author zhangqian
 * @Description 根据枚举Code 或者枚举name获取具体的枚举
 * @Date 2021/8/24 16:01
 */
public interface IEnum {
    int getCode();

    String getName();

    static <E extends Enum<E> & IEnum> E getEnum(Integer code, Class<E> clazz) {
        Objects.requireNonNull(code);
        EnumSet<E> all = EnumSet.allOf(clazz);
        return all.stream().filter(p -> p.getCode() == code).findFirst().orElse(null);
    }

    static <E extends Enum<E> & IEnum> E getEnum(String name, Class<E> clazz) {
        Objects.requireNonNull(name);
        EnumSet<E> all = EnumSet.allOf(clazz);
        return all.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }
}

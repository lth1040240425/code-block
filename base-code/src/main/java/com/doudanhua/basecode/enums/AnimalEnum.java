package com.doudanhua.basecode.enums;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * @Author zhangqian
 * @Description 枚举 可以带抽象方法，  具体枚举做具体实现
 * @Date 2021/8/24 16:05
 */
public enum AnimalEnum implements IEnum {

    Dog(1, "dog") {
        @Override
        public String say() {
            return "旺旺~~~";
        }
    },
    Bad(2, "bad") {
        @Override
        public String say() {
            return "叽叽喳喳~~~";
        }
    },
    Cat(3, "cat") {
        @Override
        public String say() {
            return "喵喵~~~";
        }
    };

    private int code;
    private String name;

    AnimalEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public abstract String say();

    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }
}

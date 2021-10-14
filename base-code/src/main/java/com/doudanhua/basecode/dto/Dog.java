package com.doudanhua.basecode.dto;

import com.alibaba.fastjson.JSONObject;
import com.doudanhua.basecode.jackjson.JacksonTypeIdResolver;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import lombok.Data;

/**
 * @Author zhangqian
 * @Description TODO
 * @Date 2020/8/28 16:24
 */
@Data
public class Dog extends Animal {
    private int age;
}

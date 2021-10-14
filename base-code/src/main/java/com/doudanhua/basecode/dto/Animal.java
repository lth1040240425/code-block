package com.doudanhua.basecode.dto;

import com.doudanhua.basecode.jackjson.JacksonTypeIdResolver;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import lombok.Data;

/**
 * @Author zhangqian
 * @Description TODO
 * @Date 2021/10/14 15:49
 */
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.CUSTOM, property = "@class")
@JsonTypeIdResolver(JacksonTypeIdResolver.class)
public class Animal {
    private String name;
}


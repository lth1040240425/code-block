package com.doudanhua.basecode.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @Author zhangqian
 * @Description TODO
 * @Date 2020/8/28 16:24
 */
@Data
public class DogDto {
    private int age;
    private String name;

//    @Override
//    public String toString() {
//        return JSONObject.toJSONString(this);
//    }
}

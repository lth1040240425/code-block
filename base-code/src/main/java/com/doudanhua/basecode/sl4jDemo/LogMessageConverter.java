package com.doudanhua.basecode.sl4jDemo;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.helpers.MessageFormatter;

import java.util.stream.Stream;

/**
 * @Author zhangqian
 * @Description log.info("{}",object) 转化输出json格式
 * 1 添加自定义converter 继承 MessageConverter
 * 1.2 重写convert 方法 处理json格式
 * 2 添加logback.xml 添加配置
 * 2.1  <conversionRule conversionWord="msg"  converterClass="com.doudanhua.basecode.sl4jDemo.LogMessageConverter"
 * />指定 自定义 MessageConverter类
 *
 *
 * 其他扩展 参考：https://www.jianshu.com/p/ade8b7c220df（关键信息脱敏）
 * @Date 2020/9/1 11:10
 */
public class LogMessageConverter extends MessageConverter {
    @Override
    public String convert(ILoggingEvent event) {
        String message = MessageFormatter.arrayFormat(event.getMessage(),
                Stream.of(event.getArgumentArray()).map(p -> {
                    if(p instanceof String){
                        //String 类型直接返回
                        return p;
                    }
                    //其他 json序列化
                   return JSONObject.toJSONString(p);
                }).toArray()).getMessage();
        return message;
    }
}

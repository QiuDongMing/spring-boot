package com.qdm.springboot.utils;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成json字符串。
     * <p>Title: pojoToJson</p>
     * <p>Description: </p>
     * @param data
     * @return
     */
    public static String objectToJson(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
//			e.printStackTrace();
            logger.error("failed convert obj {} to jsonString: the fail detail:{}",data,e.getMessage());
        }
        return null;
    }

    /**
     * 将json结果集转化为对象
     *
     * @param jsonStr json数据
     * @param clazz 对象中的object类型
     * @return
     */
    public static <T> T jsonToPojo(String jsonStr, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonStr, beanType);
            return t;
        } catch (Exception e) {
            logger.error("failed convert string {} to obj: the fail detail:{}",jsonStr,e.getMessage());
        }
        return null;
    }

    /**
     * 将json数据转换成pojo对象list
     * <p>Title: jsonToList</p>
     * <p>Description: </p>
     * @param jsonStr
     * @param beanType
     * @return
     */
    public static <T>List<T> jsonToList(String jsonStr, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonStr, javaType);
            return list;
        } catch (Exception e) {
            logger.error("failed convert string {} to obj: the fail detail:{}",jsonStr,e.getMessage());
        }
        return null;
    }



}

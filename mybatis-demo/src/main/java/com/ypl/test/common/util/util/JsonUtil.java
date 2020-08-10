package com.ypl.test.common.util.util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Json工具，将一个java对象序列化为json字符串
 *
 */
public class JsonUtil {

    private static ObjectMapper INSTANCE=new ObjectMapper();

    public static String objectToJson(Object o) {
        StringWriter sw = new StringWriter();
        JsonGenerator gen = null;
        try {
            gen = new JsonFactory().createJsonGenerator(sw);
            INSTANCE.writeValue(gen, o);
        } catch (Exception e) {
            throw new RuntimeException("不能序列化对象为Json", e);
        } finally {
            if (null != gen) {
                try {
                    gen.close();
                } catch (IOException e) {
                    gen = null;
                }
            }
        }
        return sw.toString();
    }

    /**
     * 将 json 字段串转换为 对象.
     *
     * @param json  字符串
     * @param clazz 需要转换为的类
     * @return
     */
    public static <T> T json2Object(String json, Class<T> clazz) {
        try {
            return INSTANCE.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException("将 Json 转换为对象时异常,数据是:" + json, e);
        }
    }

    /**
     * @param json 准备转换json
     * @param clazz 集合元素类型
     * @return
     * @description json字符串转换成对象集合
     * @author paul
     * @date 2017年8月12日 下午1:28:27
     * @update 2017年8月12日 下午1:28:27
     * @version V1.0
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> parseJsonList(String json, Class<T> clazz) {
        try {
            JavaType javaType = getCollectionType(ArrayList.class, clazz);
            return (List<T>) INSTANCE.readValue(json, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param collectionClass 集合类
     * @param elementClasses 集合元素类
     * @return
     * @description 获取泛型的ColloectionType
     * @author paul
     * @date 2017年8月12日 下午2:17:38
     * @update 2017年8月12日 下午2:17:38
     * @version V1.0
     */
    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return INSTANCE.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    public static String getStringValueFromJSON(JSONObject json, String key){
        if(key == null) {
            return null;
        }
        if(json == null) {
            return null;
        }
        if(!json.containsKey(key)) {
            return null;
        }
        return json.getString(key);
    }

    public static Integer getIntegerValueFromJSON(JSONObject json, String key) throws Exception{
        if(key == null) {
            return 0;
        }
        if(json == null) {
            return 0;
        }
        if(!json.containsKey(key)) {
            return 0;
        }
        return Integer.parseInt(json.getString(key));
    }

    public static Boolean getBooleanValueFromJSON(JSONObject json, String key) throws Exception{
        if(key == null) {
            return false;
        }
        if(json == null) {
            return false;
        }
        if(!json.containsKey(key)) {
            return false;
        }
        return Boolean.parseBoolean(json.getString(key));
    }

    public static Long getLongValueFromJSON(JSONObject json, String key) throws Exception{
        if(key == null) {
            return 0L;
        }
        if(json == null) {
            return 0L;
        }
        if(!json.containsKey(key)) {
            return 0L;
        }
        return Long.parseLong(json.getString(key));
    }

    public static JSONObject getJSONObjectFromJSON(JSONObject json, String key) throws Exception{
        if(key == null) {
            return null;
        }
        if(json == null) {
            return null;
        }
        if(!json.containsKey(key)) {
            return null;
        }
        return json.getJSONObject(key);
    }

    public static JSONArray getJSONArrayFromJSON(JSONObject json, String key) throws Exception{
        if(key == null) {
            return null;
        }
        if(json == null) {
            return null;
        }
        if(!json.containsKey(key)) {
            return null;
        }
        return json.getJSONArray(key);
    }
}

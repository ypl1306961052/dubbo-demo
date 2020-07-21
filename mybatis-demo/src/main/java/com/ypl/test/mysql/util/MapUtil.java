package com.ypl.test.mysql.util;
/*
作者：yangp
创建时间：2020/7/21-15:07-2020
*/


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.ReferenceUtil;
import com.sun.media.sound.SoftTuning;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: MapUtil
 * @Package com.ypl.test.mysql.util
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/21 15:07
 */


public class MapUtil {
    public static Map<String, Object> objectConvertMap(Object object) {
        Class<?> objectClass = object.getClass();
        Field[] fields = objectClass.getDeclaredFields();
        Map<String, Object> map = new HashMap<>(fields.length);
        for (Field field : fields) {
            try {
                String name = field.getName();
                field.setAccessible(true);
                Object value = null;
                value = field.get(object);
                map.put(name, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}

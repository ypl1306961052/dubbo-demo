package com.ypl.test.common.util.util;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CreateCache;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * @Author: YK
 * @Version V1.0
 * @Description
 * @Date: 2020/5/20 14:26
 */

@Service
public class CacheUtil {

    @CreateCache
    private Cache<String, Object> cache;

    /**
     * 设置值
     * @param key
     * @param value
     */
    public void set(String key,Object value){
        cache.put(key,value);
    }

    /**
     * 设置缓存及过期时间(默认为分)
     * @param key
     * @param value
     * @param timeOut
     */
    public void set(String key,Object value, long timeOut){
        cache.put(key, value, timeOut, TimeUnit.SECONDS);
    }

    /**
     * 设置缓存及过期时间
     * @param key
     * @param value
     * @param timeOut
     * @param timeUnit
     */
    public void set(String key,Object value, long timeOut, TimeUnit timeUnit){
        if(timeUnit == null){
            set(key, value, timeOut);
        }
        cache.put( key, value, timeOut, timeUnit);
    }

    /**
     * 取值
     * @param key
     * @return
     */
    public Object get(String key){
       return  cache.get(key) ;
    }

    /**
     * 移除缓存
     * @param key
     * @return
     */
    public boolean remove(String key){
        return cache.remove(key);
    }

    /**
     * 移除所有缓存
     * @param keys
     */
    public void removeAll(Set keys){
        cache.removeAll(keys);
    }

    /**
     * 获取所有缓存
     * @param keys
     * @return
     */
    public Map getAll(Set keys){
        Map map = cache.getAll(keys);
        return map;
    }

}

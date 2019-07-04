package com.xlkj.website.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangshuo on 2018/6/27.
 */
@Repository
public class RedisDao {

    @Autowired
    private StringRedisTemplate template;

    public  void setKey(String key,String value){
        template.opsForValue().set(key, value,60*180, TimeUnit.SECONDS);//向redis里存入数据和设置缓存时间
    }

    public String getValue(String key) {
        String result=template.opsForValue().get(key);
        if(result==null){
            return result;
        }
        template.opsForValue().set(key, result, 60 * 180, TimeUnit.SECONDS);
        return result;
    }

}

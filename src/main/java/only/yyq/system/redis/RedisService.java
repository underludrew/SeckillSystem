package only.yyq.system.redis;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
public class RedisService {
    @Autowired
    JedisPool jedispool;



    public <T>T get(String key,Class<T> clazz){
        Jedis jedis=null;

        try {
            jedis = jedispool.getResource();
            String str = jedis.get(key);
            T t = stringtoBean(str,clazz);
            return t;
        }finally {
            returnToPool(jedis);
        }
    }

    private void returnToPool(Jedis jedis) {
        if(jedis!=null){
            jedis.close();
        }
    }

    public <T> boolean set(String key,T value,int expireseconds){
        Jedis jedis=null;
        try {
            jedis = jedispool.getResource();
            String str = BeanTostring(value);
            if(str==null){
                return false;
            }
            jedis.set(key,str);
            jedis.expire(key,expireseconds);
            return true;
        }finally {
            returnToPool(jedis);
        }
    }

    private <T> String BeanTostring(T value) {
        if(value==null){
            return null;
        }else if(value.getClass()==int.class||value.getClass()== Integer.class){
            return  ""+value;
        }
        else if(value.getClass()==String.class){
            return (String)value;
        }else if(value.getClass()==long.class||value.getClass()==Long.class){
            return  ""+value;
        }else{
            return JSON.toJSONString(value);
        }

    }

    private <T> T stringtoBean(String str,Class<T> clazz) {
         if(str==null||str.length()<=0||clazz==null){
             return null;
         }
         if (clazz==int.class||clazz==Integer.class)
         {
             return (T)Integer.valueOf(str);
         }else if(clazz==String.class){
             return (T)str;
         }else if(clazz==long.class||clazz==Long.class){
             return (T)Long.valueOf(str);
         }else {
             return JSON.toJavaObject(JSON.parseObject(str),clazz);
         }
    }


}

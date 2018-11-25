package com.demo.redis;


import com.demo.bean.User;
import com.demo.redis.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @author joncjing
 * @description
 * @date 2018/09/26-17/44
 **/
@Component
public class UserDaoImpl extends BaseRedisDao<String,User> implements UserDao {
    private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public boolean add(final User user) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key = serializer.serialize(String.valueOf(user.getAddress()));
                byte[] name = serializer.serialize(user.getUsername());
                return redisConnection.setNX(key,name);
            }
        });
        return result;
    }
}

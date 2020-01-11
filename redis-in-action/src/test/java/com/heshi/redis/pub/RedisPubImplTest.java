package com.heshi.redis.pub;

import com.heshi.redis.common.BasePubMessage;
import com.heshi.redis.common.RedisChannelEnums;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisPubImplTest implements Serializable {

    @Autowired
    private RedisPubImpl redisPub;

    @Test
    public void testSendMessage() {
        BasePubMessage basePubMessage = new BasePubMessage() {

            @Override
            public String getChannel() {
                return super.getChannel();
            }

            @Override
            public String getExtra() {
                return "something";
            }
        };
        redisPub.sendMessage(RedisChannelEnums.CHANGE_URI_TIME_OUT, basePubMessage);
    }

}
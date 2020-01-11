package com.heshi.redis.common;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * redis 消息发送模板
 */
public abstract class BasePubMessage implements Serializable {
    private static final long serialVersionUID = 3231984137432906763L;
    protected String channel;
    protected String extra;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

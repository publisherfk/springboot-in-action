package com.heshi.redis.sub;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;

public abstract class BaseSubMessage {
    private String channel;
    private String extra;
    private String json;

    BaseSubMessage(String json) {
        if (StringUtils.isEmpty(json)) {
            return;
        }
        this.json = json;
        BaseSubMessage subMessage = JSON.parseObject(json, BaseSubMessage.class);
        this.channel = subMessage.getChannel();
        this.extra = subMessage.getExtra();
    }

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

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}

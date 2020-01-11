package com.heshi.redis.common;

import com.heshi.redis.sub.BaseSub;

import java.util.Arrays;
import java.util.Optional;

/**
 * 维护redis通道信息
 */
public enum RedisChannelEnums {
    INFO_CHANNEL("INFO_CHANNEL", "CHANNEL INFO"),
    CHANGE_URI_TIME_OUT("CHANGE_URI_TIME_OUT", "CHANGE URI TIME OUT");
    private String code;
    private Class<? extends BaseSub> className;
    private String description;

    RedisChannelEnums(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * 根据code获取对应的枚举对象
     */
    public static RedisChannelEnums getEnum(String code) {
        RedisChannelEnums[] values = RedisChannelEnums.values();
        Optional<RedisChannelEnums> optRedisChannelEnums = Arrays.stream(values).filter(redisChannelEnums -> redisChannelEnums.code == code).findFirst();
        if (optRedisChannelEnums.isPresent()) {
            return optRedisChannelEnums.get();
        } else {
            return null;
        }
    }

    /**
     * 查询code在枚举列表中是否存在
     *
     * @param code
     * @return
     */
    public static Boolean containsCode(String code) {
        RedisChannelEnums channelEnums = getEnum(code);
        return channelEnums != null;
    }

    /**
     * 判断code与枚举中的code是否相同
     *
     * @param code
     * @param redisChannelEnums
     * @return
     */
    public static Boolean equals(String code, RedisChannelEnums redisChannelEnums) {
        return redisChannelEnums != null && redisChannelEnums.code.equals(code);
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Class<? extends BaseSub> getClassName() {
        return className;
    }
}

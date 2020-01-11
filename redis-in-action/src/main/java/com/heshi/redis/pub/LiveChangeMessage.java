package com.heshi.redis.pub;

import com.heshi.redis.common.BasePubMessage;

public class LiveChangeMessage extends BasePubMessage {
    private String liveIds;

    public String getLiveIds() {
        return liveIds;
    }

    public void setLiveIds(String liveIds) {
        this.liveIds = liveIds;
    }
}
